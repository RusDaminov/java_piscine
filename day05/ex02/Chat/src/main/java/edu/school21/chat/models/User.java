package edu.school21.chat.models;

import java.util.List;
import java.util.Objects;

public class User {
    private Long id;
    private String login;
    private String password;
    List<Chatroom> allRooms;
    List<Chatroom> ownRooms;

    public User(Long id, String login, String password, List<Chatroom> allRooms, List<Chatroom> ownRooms) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.allRooms = allRooms;
        this.ownRooms = ownRooms;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Chatroom> getAllRooms() {
        return allRooms;
    }

    public void setAllRooms(List<Chatroom> allRooms) {
        this.allRooms = allRooms;
    }

    public List<Chatroom> getOwnRooms() {
        return ownRooms;
    }

    public void setOwnRooms(List<Chatroom> ownRooms) {
        this.ownRooms = ownRooms;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id) && login.equals(user.login) && password.equals(user.password) && Objects.equals(allRooms, user.allRooms) && Objects.equals(ownRooms, user.ownRooms);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, allRooms, ownRooms);
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", allRooms=" + allRooms +
                ", ownRooms=" + ownRooms +
                '}';
    }
}
