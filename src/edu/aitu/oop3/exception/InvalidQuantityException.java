package edu.aitu.oop3.exception;

public class InvalidQuantityException extends RuntimeException {
    public InvalidQuantityException(int quantity) {
        super("Invalid quantity: " + quantity + ". Quantity must be > 0.");
    }
}
