package mx.com.Axity.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang.builder.CompareToBuilder;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "users", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
public class UserDO implements Comparable<UserDO>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "ds_name")
    private String name;
    @Column(name = "ds_lastname")
    private String lastName;
    @Column(name = "age")
    private int age;

    @Override
    public int compareTo(UserDO o) {
        return new CompareToBuilder().append(this.id, o.id).toComparison();
    }
}
