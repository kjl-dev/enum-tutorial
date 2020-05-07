package d.withgenerics.b;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@Getter
public enum OrderStatus implements EnumValueType{

    CANCELLED("X"),
    COMPLETED("C"),
    IN_PROGRESS("P"),
    REFUNDED("R");

    //@JsonValue
    private String value;

    @JsonCreator
    public static OrderStatus fromValue(final String value) {
        return EnumUtil.fromStringValue(OrderStatus.class, value);
    }
}
