package b.RestControllers.b.springparams;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.ToString;

@ToString
public enum OrderStatus {

    CANCELLED,
    COMPLETED,
    IN_PROGRESS,
    REFUNDED;

    public static OrderStatus fromValue(final String value) {

        return OrderStatus.valueOf(value.toUpperCase());
    }

}
