package mx.com.Axity.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "computers", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
public class ComputerDO implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "computer_id")
    private Long computerId;
    @Column(name = "keyboard_id")
    private Integer keyboardId;
    @Column(name = "mouse_id")
    private Integer mouseId;
    @Column(name = "monitor_id")
    private Integer monitorId;
    @Column(name = "order_id")
    private Integer orderId;
    @Column(name = "brand")
    private String brand;
    @Column(name = "serial_number")
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

    public int compareTo(ComputerDO o) {
        return new CompareToBuilder().append(this.computerId, o.computerId).toComparison();
    }

}
