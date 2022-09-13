package mx.com.Axity.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "mice", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
public class ComputerDO implements Comparable<ComputerDO>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "computer_id")
    private Long computerId;
    @Column(name = "keyboard_id")
    private Long keyboardId;
    @Column(name = "mouse_id")
    private Long mouseId;
    @Column(name = "monitor_id")
    private Long monitorId;
    @Column(name = "brand")
    private String brand;
    @Column(name = "serial_number")
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
    @Override
    public int compareTo(ComputerDO o) {
        return new CompareToBuilder().append(this.computerId, o.computerId).toComparison();
    }

}
