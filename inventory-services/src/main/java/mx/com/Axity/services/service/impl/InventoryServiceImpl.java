package mx.com.Axity.services.service.impl;

import mx.com.Axity.commons.to.*;
import mx.com.Axity.model.ComputerDO;
import mx.com.Axity.model.MouseDO;
import mx.com.Axity.model.OrderDO;
import mx.com.Axity.model.UserDO;
import mx.com.Axity.persistence.ComputerDAO;
import mx.com.Axity.persistence.MouseDAO;
import mx.com.Axity.persistence.OrderDAO;
import mx.com.Axity.persistence.UserDAO;
import mx.com.Axity.services.service.IInventoryService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InventoryServiceImpl implements IInventoryService {

    static final Logger LOG = LogManager.getLogger(InventoryServiceImpl.class);

    @Autowired
    UserDAO userDAO;
    @Autowired
    MouseDAO mouseDAO;
    @Autowired
    ComputerDAO computerDAO;
    @Autowired
    OrderDAO orderDAO;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<UserTO> getUsers() {

        LOG.info("Consultando usuarios");
        List<UserDO> usersDO = this.userDAO.findByLastName("Romero");

        Type userDAOType = new TypeToken<List<UserDO>>() {}.getType();
        List<UserTO> usersTO = this.modelMapper.map(usersDO, userDAOType);
        LOG.info("Se retornan {} elementos", usersTO.size());

        return usersTO;
    }



    //Para la parte de mice
    @Override
    public MouseTO getMouseById(long mouseId) {

        LOG.info("Obteniendo valor para el parámetro " + mouseId);

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        MouseDO mouseDo = mouseDAO.findByMouseId(mouseId);
        MouseTO returnValue = modelMapper.map((Object) mouseDo, (Type) MouseTO.class);

        return returnValue;
    }

    @Override
    public List<MouseTO> getAllMice() {

        LOG.info("Obteniendo todos los ratones ");

        List<MouseDO> mouseDo =  (List<MouseDO>) mouseDAO.findAll();

        return mouseDo.stream().map(this::convertToTO).collect(Collectors.toList());

    }

    private MouseTO convertToTO(MouseDO mouse) {

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        MouseTO mouseTo = modelMapper.map(mouse, MouseTO.class);

        return mouseTo;
    }


    //Parte de las computadoras

    @Override
    public ResponseTO createComputer(ComputerTO computer){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        ComputerDO computerDO=modelMapper.map(computer, ComputerDO.class);
        computerDAO.save(computerDO);
        ResponseTO responseValue = new ResponseTO();

        responseValue.setCode(201);
        responseValue.setMessage("La computadora se ha registrado con el identificador --> " + computerDO.getComputerId());

        return responseValue;
    }

    @Override
    public OrderTO getOrderById(long orderId) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        OrderDO orderDO=orderDAO.findByOrderId(orderId);
        OrderTO orderTO=new OrderTO();
        orderTO.setOrderId(orderId);
        orderTO.setDescription(orderDO.getDescription());
        List<ComputerDO> listado=computerDAO.findByOrderId((int)orderId);
        List<ComputerTO> listato=new ArrayList<>();
        for (int i=0;i<listado.size();i++){
            listato.add(modelMapper.map(listado.get(i), ComputerTO.class));
        }
        orderTO.setComputers(listato);
        return orderTO;
    }

    //el método creteOrder no necesita el id

    @Override
    public ResponseTO createOrder(OrderTO order) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        OrderDO orderDO=new OrderDO();
        orderDO.setDescription(order.getDescription());
        List<ComputerTO> computers=order.getComputers();
        ResponseTO responseValue = new ResponseTO();
        ComputerDO computerDO=new ComputerDO();
        if (computers.size()>5){
            responseValue.setCode(400);
            responseValue.setMessage("Una orden no puede tener más de 5 computadoras --> " + orderDO.getOrderId());
            return responseValue;
        }
        orderDAO.save(orderDO);
        for (int i=0;i<computers.size();i++){
            //if(computers.get(i).getComputerId()!=null||computers.get(i).getOrderId()!=null){
            //    responseValue.setCode(400);
            //    responseValue.setMessage("Ya existe una computadora con este id --> " + computers.get(i).getComputerId()+" porfavor ingrese un valor nulo ");
            //    return responseValue;
            //}
            computerDO=modelMapper.map(computers.get(i), ComputerDO.class);
            computerDO.setOrderId(Math.toIntExact(orderDO.getOrderId()));
            computerDAO.save(computerDO);
        }

        responseValue.setCode(200);
        responseValue.setMessage("Orden guardada con el id --> " + orderDO.getOrderId());
        return responseValue;
    }

}
