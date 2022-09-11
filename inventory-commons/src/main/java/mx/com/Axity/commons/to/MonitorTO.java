package mx.com.Axity.commons.to;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class MonitorTO implements Serializable {
    private Long monitorId;
    private String brand;
    private Integer serialNumber;
    private String model;
}
