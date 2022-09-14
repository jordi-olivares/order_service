package mx.com.Axity.persistence;

import mx.com.Axity.model.ComputerDO;
import mx.com.Axity.model.MouseDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComputerDAO extends CrudRepository<ComputerDO,Long> {
    ComputerDO findByComputerId(Long computerId);
}
