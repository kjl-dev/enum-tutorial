package b.RestControllers.b.jackson;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.ToString;

public enum OrderStatus {

    CANCELLED,
    COMPLETED,
    IN_PROGRESS,
    REFUNDED;

    /**
     * Jackson invokes the method with the @JsonCreator annotation to create the enum.
     *
     * Note that for Jackson  on this specific example
     * you could have also created a new ObjectMapper with a feature enabled
     * that allows you to ACCEPT_CASE_INSENSITIVE_ENUMS, but that has other consequences.
     *
     * @param value
     * @return
     */
    @JsonCreator
    public static OrderStatus fromValue(final String value) {

        return OrderStatus.valueOf(value.toUpperCase());
    }

}
