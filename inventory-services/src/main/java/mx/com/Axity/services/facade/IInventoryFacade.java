package mx.com.Axity.services.facade;

import mx.com.Axity.commons.to.ComputerTO;
import mx.com.Axity.commons.to.MouseTO;
import mx.com.Axity.commons.to.ResponseTO;
import mx.com.Axity.commons.to.UserTO;

import java.util.List;

public interface IInventoryFacade {

    List<UserTO> getAllUsers();
    List<MouseTO> getAllMice();
    MouseTO getMouseById(long mouseId);
    ResponseTO createComputer(ComputerTO computer);

}
