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
@Table(name = "keyboeards", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
public class KeyboardDO implements Comparable<KeyboardDO>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "keyboard_id")
    private Long keyboardId;
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
                .append("keyboard Id", this.keyboardId)
                .append("Brand", this.brand)
                .append("Serial Number", this.serialNumber)
                .append("model", this.model)
                .toString();
    }
    @Override
    public int compareTo(KeyboardDO o) {
        return new CompareToBuilder().append(this.keyboardId, o.keyboardId).toComparison();
    }

}
