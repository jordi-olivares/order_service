package mx.com.Axity.persistence;


import mx.com.Axity.model.MouseDO;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MouseDAO extends CrudRepository<MouseDO,Long> {
    MouseDO findByMouseId(long mouseId);


}
