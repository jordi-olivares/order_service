package mx.com.Axity.services.service;

import mx.com.Axity.commons.to.*;

import java.util.List;

public interface IInventoryService {

    List<UserTO> getUsers();


    //Métodos para la orden
    ResponseTO createComputer(ComputerTO computer);
    OrderTO getOrderById(long orderId);
    ResponseTO createOrder(OrderTO order);
}
