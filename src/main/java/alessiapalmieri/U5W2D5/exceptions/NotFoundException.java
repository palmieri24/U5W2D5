package alessiapalmieri.U5W2D5.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(int id) {
        super(id + " not found!");
    }
}
