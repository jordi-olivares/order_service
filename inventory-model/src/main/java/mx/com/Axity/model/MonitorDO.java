package mx.com.Axity.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "monitors", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
public class MonitorDO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "monitor_id")
    private Long monitorId;
    @Column(name = "brand")
    private String brand;
    @Column(name = "serial_number")
    private Integer serialNumber;
    @Column(name = "model")
    private String model;
}
