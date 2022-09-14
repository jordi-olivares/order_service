package mx.com.Axity.persistence;

import mx.com.Axity.model.OrderDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDAO extends JpaRepository<OrderDO,Long> {
    OrderDO findByOrderId(Long orderId);
}
