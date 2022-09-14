package mx.com.Axity.commons.to;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;
@Getter
@Setter
public class ComputerTO implements Serializable {
    private Long computerId;
    private Integer keyboardId;
    private Integer mouseId;
    private Integer monitorId;
    private Integer orderId;
    private String brand;
    private Integer serialNumber;
    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("computer id",this.computerId)
                .append("keyboard id",this.keyboardId)
                .append("mouseId", this.mouseId)
                .append("monitor id",this.monitorId)
                .append("order id",this.orderId)
                .append("Brand", this.brand)
                .append("Serial Number", this.serialNumber)
                .toString();
    }
}
