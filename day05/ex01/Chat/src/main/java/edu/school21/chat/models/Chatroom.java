package edu.school21.chat.models;

import java.util.List;
import java.util.Objects;

public class Chatroom {
    private Integer id;
    private String name;
    private String owner;
    private List<Message> chatMessages;

    public Chatroom(Integer id, String name, String owner, List<Message> chatMessages) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.chatMessages = chatMessages;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public List<Message> getChatMessages() {
        return chatMessages;
    }

    public void setChatMessages(List<Message> chatMessages) {
        this.chatMessages = chatMessages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chatroom chatroom = (Chatroom) o;
        return id.equals(chatroom.id) && name.equals(chatroom.name) && owner.equals(chatroom.owner) && Objects.equals(chatMessages, chatroom.chatMessages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, owner, chatMessages);
    }

    @Override
    public String toString() {
        return
                "{id=" + id +
                ", name='" + name + '\'' +
                ", owner='" + owner + '\'' +
                ", chatMessages=" + chatMessages +
                '}';
    }
}
