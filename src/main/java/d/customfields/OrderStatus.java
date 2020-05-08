package d.customfields;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

// Lombok works with enums too!
// Could we have a setter here?
@ToString
@Getter
@AllArgsConstructor
public enum OrderStatus {

    // These arguments are passed directly to the constructor.
    // Constructors can be overloaded.
    CANCELLED("X"),
    COMPLETED("C"),
    IN_PROGRESS("P"),
    REFUNDED("R");

    private final String statusCode;

}
