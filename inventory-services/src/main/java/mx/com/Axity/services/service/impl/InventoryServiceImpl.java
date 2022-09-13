package mx.com.Axity.services.service.impl;

import mx.com.Axity.commons.to.ComputerTO;
import mx.com.Axity.commons.to.MouseTO;
import mx.com.Axity.commons.to.ResponseTO;
import mx.com.Axity.commons.to.UserTO;
import mx.com.Axity.model.ComputerDO;
import mx.com.Axity.model.MouseDO;
import mx.com.Axity.model.UserDO;
import mx.com.Axity.persistence.ComputerDAO;
import mx.com.Axity.persistence.MouseDAO;
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

}
