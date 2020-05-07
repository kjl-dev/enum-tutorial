package d.customfieldswithspring;

import java.util.EnumSet;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

@ToString
@AllArgsConstructor
@Getter
public enum OrderStatus {

    CANCELLED("X"),
    COMPLETED("C"),
    IN_PROGRESS("P"),
    REFUNDED("R");

    private String statusCode;

    public static OrderStatus fromValue(final String value) {

        if (StringUtils.isBlank(value)) {
            throw new IllegalArgumentException("No value supplied to lookup OrderStatus");
        }

       EnumSet<OrderStatus> enumSet = EnumSet.allOf(OrderStatus.class);
       Optional<OrderStatus> result = enumSet
               .stream()
               .filter(type -> type.getStatusCode().equalsIgnoreCase(value))
               .findFirst();

       if(!result.isPresent()) {
            throw new IllegalArgumentException(String.format("Invalid value a {} for OrderStatus", value));
       }

       return result.get();
    }


}
