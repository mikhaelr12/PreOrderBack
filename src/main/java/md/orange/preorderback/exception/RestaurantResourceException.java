package md.orange.preorderback.exception;

import java.io.Serial;

public class RestaurantResourceException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;
    public RestaurantResourceException(String message) {

        super(message);
    }
}
