package mx.com.Axity.persistence;


import mx.com.Axity.model.MouseDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MouseDAO extends JpaRepository<MouseDO,Long> {
    MouseDO findByMouseId(long mouseId);


}
