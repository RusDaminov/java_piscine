package edu.school21.chat.models;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;

public class Message {
    private Integer id;
    private User author;
    private Chatroom room;
    private String messageText;
    private Timestamp time;



    public Message(Integer id, User author, Chatroom room, String messageText, Timestamp time) {
        this.id = id;
        this.author = author;
        this.room = room;
        this.messageText = messageText;
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Chatroom getRoom() {
        return room;
    }

    public void setRoom(Chatroom room) {
        this.room = room;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return id.equals(message.id) && author.equals(message.author) && room.equals(message.room) && messageText.equals(message.messageText) && time.equals(message.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, room, messageText, time);
    }

    @Override
    public String toString() {
        return "Message: {\n" +
                "id=" + id +
                ",\nauthor=" + author +
                ",\nroom=" + room +
                ",\ntext='" + messageText + '\'' +
                ",\ndateTime=" + time +
                '}';
    }
}
