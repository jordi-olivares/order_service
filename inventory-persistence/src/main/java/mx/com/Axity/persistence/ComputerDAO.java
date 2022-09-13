package mx.com.Axity.persistence;

import mx.com.Axity.model.ComputerDO;
import mx.com.Axity.model.MouseDO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComputerDAO extends JpaRepository<ComputerDO,Long> {
    ComputerDO findByComputerId(long computerId);
}
