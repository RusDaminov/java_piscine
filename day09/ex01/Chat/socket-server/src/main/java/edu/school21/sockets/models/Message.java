package edu.school21.sockets.models;

import java.time.LocalDateTime;
import java.util.Objects;

public class Message {

    private Long id;
    private String messageText;
    private LocalDateTime time;

    public Message(String messageText, LocalDateTime time) {
        this.messageText = messageText;
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return id.equals(message.id) && messageText.equals(message.messageText) && time.equals(message.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, messageText, time);
    }

    @Override
    public String toString() {
        return "Message: {\n" +
                "id=" + id +
                ",\ntext='" + messageText + '\'' +
                ",\ndateTime=" + time +
                '}';
    }
}
