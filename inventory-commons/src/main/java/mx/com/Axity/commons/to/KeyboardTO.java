package mx.com.Axity.commons.to;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;

@Getter
@Setter
public class KeyboardTO implements Serializable {
    private Long keyboardId;
    private String brand;
    private Integer serialNumber;
    private String model;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("keyboard Id", this.keyboardId)
                .append("Brand", this.brand)
                .append("Serial Number", this.serialNumber)
                .append("model", this.model)
                .toString();
    }

}
