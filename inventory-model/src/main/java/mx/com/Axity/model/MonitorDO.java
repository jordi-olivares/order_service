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
@Table(name = "monitors", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
public class MonitorDO implements Comparable<MonitorDO> {
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

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("keyboard Id", this.monitorId)
                .append("Brand", this.brand)
                .append("Serial Number", this.serialNumber)
                .append("model", this.model)
                .toString();
    }
    @Override
    public int compareTo(MonitorDO o) {
        return new CompareToBuilder().append(this.monitorId, o.monitorId).toComparison();
    }
}
