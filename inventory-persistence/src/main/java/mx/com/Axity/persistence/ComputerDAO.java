package mx.com.Axity.persistence;

import mx.com.Axity.model.ComputerDO;
import mx.com.Axity.model.MouseDO;
import mx.com.Axity.model.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ComputerDAO extends JpaRepository<ComputerDO,Long> {
    ComputerDO findByComputerId(Long computerId);
    List<ComputerDO> findByOrderId(int orderId);
}
