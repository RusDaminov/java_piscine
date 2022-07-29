//package ex00;

import java.util.UUID;
enum Category {
    DEBITS,
    CREDITS
}
public class Transaction {
    private UUID identifier;
    private User recipient;
    private User sender;
    private Category category;
    private Integer transferAmount;

    public Transaction(UUID identifier, User recipient, User sender, Integer transferAmount) {
        if(transferAmount < 0)
            this.category = Category.CREDITS;
        if(transferAmount >= 0);
            this.category = Category.DEBITS;
        this.identifier = identifier;
        this.recipient = recipient;
        this.sender = sender;
        this.category = category;
        this.transferAmount = transferAmount;
    }

    public void setIdentifier(UUID identifier) {
        identifier = identifier;
    }

    public void setRecipient(User recipient) {
        recipient = recipient;
    }

    public void setSender(User sender) {
        sender = sender;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setTransferAmount(Integer transferAmount) {
        this.transferAmount = transferAmount;
    }

    public UUID getIdentifier() {
        return identifier;
    }

    public User getRecipient() {
        return recipient;
    }

    public User getSender() {
        return sender;
    }

    public Category getCategory() {
        return category;
    }

    public Integer getTransferAmount() {
        return transferAmount;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Transaction{" +
                "identifier=" + identifier +
                ",\n recipient=" + recipient +
                ",\n sender=" + sender +
                ",\n category=" + category +
                ", transferAmount=" + transferAmount +
                '}';
    }
}
