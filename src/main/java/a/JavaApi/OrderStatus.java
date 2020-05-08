package a.JavaApi;

import java.lang.Enum;

/**
 * A basic enum.
 *
 * All enums implicitly extend java.lang.Enum.
 *
 * Enums can be declared inside or outside of a class, but not in a method.
 */
public enum OrderStatus {

    // Other useful points
    // These instances are implicitly static and final.
    // These instances are singletons - You cannot programmatically create instances with the NEW keyword.

    // Order may be relevant depending on your code!
    CANCELLED,
    COMPLETED,
    IN_PROGRESS,
    REFUNDED  // ; required only if there is additional code

}
