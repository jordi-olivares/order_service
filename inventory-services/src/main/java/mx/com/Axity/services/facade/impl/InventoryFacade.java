package mx.com.Axity.services.facade.impl;

import mx.com.Axity.commons.to.*;
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

    @Override
    public List<MouseTO> getAllMice() {
        return this.inventoryService.getAllMice();
    }

    @Override
    public MouseTO getMouseById(long mouseId) {
        return this.inventoryService.getMouseById(mouseId);
    }

    @Override
    public ResponseTO createComputer(ComputerTO computer) {
        return this.inventoryService.createComputer(computer);
    }

    @Override
    public OrderTO getOrderById(long orderId) {
        return this.inventoryService.getOrderById(orderId);
    }
}
