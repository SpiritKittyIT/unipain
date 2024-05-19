package cardAdventure.exceptions;

/**
* Class to represent exception thrown when instance is not initialised.
*/
public class NotInitialisedException extends RuntimeException {
    /**
    * Default constructor for NotInitialisedException class members.
    * @param message the exception message
    */
    public NotInitialisedException(String message) {
        super(message);
    }
}
