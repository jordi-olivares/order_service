package mx.com.Axity.persistence;

import mx.com.Axity.model.KeyboardDO;
import mx.com.Axity.model.MouseDO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KeyboardDAO extends JpaRepository<KeyboardDO,Long> {
    KeyboardDO findByKeyboardId(long keyboardId);
}
