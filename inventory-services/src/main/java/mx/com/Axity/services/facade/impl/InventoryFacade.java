package mx.com.Axity.services.facade.impl;

import mx.com.Axity.commons.to.UserTO;
import mx.com.Axity.services.facade.IInventoryFacade;
import mx.com.Axity.services.service.IInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class InventoryFacade implements IInventoryFacade {

    @Autowired
    private IInventoryService inventoryService;

    public List<UserTO> getAllUsers() {
        return this.inventoryService.getUsers();
    }
}
