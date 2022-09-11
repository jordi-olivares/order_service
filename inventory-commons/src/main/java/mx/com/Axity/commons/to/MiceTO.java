package mx.com.Axity.commons.to;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class MiceTO implements Serializable {
    private Long mouseId;
    private String brand;
    private Integer serialNumber;
    private String model;
}
