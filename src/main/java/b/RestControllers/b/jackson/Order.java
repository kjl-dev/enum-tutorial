package b.RestControllers.b.jackson;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString
public class Order {

    private String orderId;
    private OrderStatus orderStatus;
}
