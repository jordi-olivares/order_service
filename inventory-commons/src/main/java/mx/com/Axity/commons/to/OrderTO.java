package mx.com.Axity.commons.to;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class OrderTO {
    private Long orderId;
    private String description;
    private List<ComputerTO> computers;
    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("mouseId", this.orderId)
                .append("Brand", this.description)
                .append("computers",this.computers)
                .toString();
    }
}
