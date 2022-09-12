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
public class MouseDO implements Comparable<MouseDO>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mouse_id")
    private Long mouseId;
    @Column(name = "brand")
    private String brand;
    @Column(name = "serial_number")
    private Integer serialNumber;
    @Column(name = "model")
    private String model;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("mouseId", this.mouseId)
                .append("Brand", this.brand)
                .append("Serial Number", this.serialNumber)
                .append("model", this.model)
                .toString();
    }
    @Override
    public int compareTo(MouseDO o) {
        return new CompareToBuilder().append(this.mouseId, o.mouseId).toComparison();
    }
}
