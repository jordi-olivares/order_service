package mx.com.Axity.persistence;

import mx.com.Axity.model.ComputerDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComputerDAO extends JpaRepository<ComputerDO,Long> {
    ComputerDO findByComputerId(Long computerId);
    List<ComputerDO> findByOrderId(int orderId);
}
