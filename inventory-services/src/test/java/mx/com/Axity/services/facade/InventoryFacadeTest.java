package mx.com.Axity.services.facade;

import mx.com.Axity.commons.to.UserTO;
import mx.com.Axity.services.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class InventoryFacadeTest extends BaseTest {

    @Test
    public void ShouldReturnAllUsers() {

        List<UserTO> users = this.inventoryFacade.getAllUsers();

        Assert.assertEquals(1, users.size());
    }
}