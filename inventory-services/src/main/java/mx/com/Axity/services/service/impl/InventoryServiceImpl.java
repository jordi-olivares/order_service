package mx.com.Axity.services.service.impl;

import mx.com.Axity.commons.to.UserTO;
import mx.com.Axity.model.UserDO;
import mx.com.Axity.persistence.UserDAO;
import mx.com.Axity.services.service.IInventoryService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.reflect.Type;
import java.util.List;

@Service
public class InventoryServiceImpl implements IInventoryService {

    static final Logger LOG = LogManager.getLogger(InventoryServiceImpl.class);

    @Autowired
    UserDAO userDAO;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<UserTO> getUsers() {

        LOG.info("Consultando usuarios");
        List<UserDO> usersDO = this.userDAO.findByLastName("Rodriguez");

        Type userDAOType = new TypeToken<List<UserDO>>() {}.getType();
        List<UserTO> usersTO = this.modelMapper.map(usersDO, userDAOType);
        LOG.info("Se retornan {} elementos", usersTO.size());

        return usersTO;
    }
}
