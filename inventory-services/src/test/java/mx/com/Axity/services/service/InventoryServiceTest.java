package mx.com.Axity.services.service;

import mx.com.Axity.commons.to.UserTO;
import mx.com.Axity.services.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class InventoryServiceTest extends BaseTest {

    @Test
    public void exampleTest() {

        List<UserTO> users = this.inventoryService.getUsers();

        Assert.assertEquals(1, users.size());
    }
}
