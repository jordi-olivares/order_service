package mx.com.Axity.services.facade;

import mx.com.Axity.commons.to.*;

import java.util.List;

public interface IInventoryFacade {

    List<UserTO> getAllUsers();
    List<MouseTO> getAllMice();
    MouseTO getMouseById(long mouseId);
    ResponseTO createComputer(ComputerTO computer);
    OrderTO getOrderById(long orderId);

}
