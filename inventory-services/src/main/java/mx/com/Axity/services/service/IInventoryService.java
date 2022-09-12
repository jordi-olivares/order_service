package mx.com.Axity.services.service;

import mx.com.Axity.commons.to.MouseTO;
import mx.com.Axity.commons.to.ResponseTO;
import mx.com.Axity.commons.to.UserTO;
import java.util.List;

public interface IInventoryService {

    List<UserTO> getUsers();
    MouseTO getMouseById(long userId);
    List<MouseTO> getAllMice();
    //ResponseTO createMouse(UserTO user);
    //ResponseTO updateMouse(int usrId, UserTO user);
    //ResponseTO deleteMouse(int usrId, UserTO user);

}
