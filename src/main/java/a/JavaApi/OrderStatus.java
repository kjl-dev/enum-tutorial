package a.JavaApi;

import lombok.ToString;

/**
 * A basic enum.
 *
 * Order may be relevant depending on your code!
 */
public enum OrderStatus {


    CANCELLED,
    COMPLETED,
    IN_PROGRESS,
    REFUNDED  // ; required only if there is additional code

}
