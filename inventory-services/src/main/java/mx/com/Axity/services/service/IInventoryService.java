package mx.com.Axity.services.service;

import mx.com.Axity.commons.to.*;

import java.util.List;

public interface IInventoryService {

    List<UserTO> getUsers();
    MouseTO getMouseById(long userId);
    List<MouseTO> getAllMice();
    //ResponseTO createMouse(UserTO user);
    //ResponseTO updateMouse(int usrId, UserTO user);
    //ResponseTO deleteMouse(int usrId, UserTO user);

    //Métodos para la orden
    ResponseTO createComputer(ComputerTO computer);
    OrderTO getOrderById(long orderId);

}
