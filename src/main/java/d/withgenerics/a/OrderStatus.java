package d.withgenerics.a;

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

    //@JsonValue
    private String statusCode;


    // Nearly duplicate code!
    @JsonCreator
    public static OrderStatus fromValue(final String value) {

        if(StringUtils.isBlank(value)) {
            throw new IllegalArgumentException(String.format("Invalid value a {} for OrderStatus", value));
        }

        String trimmedValue = StringUtils.trim(value);

       Optional<OrderStatus> result = EnumSet.allOf(OrderStatus.class)
               .stream()
               .filter(type -> type.getStatusCode().equalsIgnoreCase(trimmedValue))
               .findFirst();

       if(!result.isPresent()) {
            throw new IllegalArgumentException(String.format("Invalid value a {} for OrderStatus", trimmedValue));
       }

       return result.get();
    }
}
