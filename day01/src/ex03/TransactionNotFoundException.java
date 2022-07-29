package ex03;

import java.util.UUID;

public class TransactionNotFoundException extends RuntimeException {
    public TransactionNotFoundException(UUID identifier) {
        super("Transaction with id: " + identifier + " is not found");
    }
}
