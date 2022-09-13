package mx.com.Axity.commons.to;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;
@Getter
@Setter
public class ComputerTO implements Serializable {
    private Long computerId;
    private Long keyboardId;
    private Long mouseId;
    private Long monitorId;
    private String brand;
    private int serialNumber;

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
                .append("Brand", this.brand)
                .append("Serial Number", this.serialNumber)
                .toString();
    }
}
