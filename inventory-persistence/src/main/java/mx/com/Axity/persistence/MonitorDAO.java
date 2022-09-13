package mx.com.Axity.persistence;

import mx.com.Axity.model.MonitorDO;
import mx.com.Axity.model.MouseDO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonitorDAO extends JpaRepository<MonitorDO,Long> {
    MonitorDO findByMonitorId(long monitorId);
}
