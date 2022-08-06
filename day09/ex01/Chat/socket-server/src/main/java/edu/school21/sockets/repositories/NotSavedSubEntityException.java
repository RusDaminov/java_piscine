package edu.school21.sockets.repositories;

public class NotSavedSubEntityException extends RuntimeException{
    NotSavedSubEntityException() {
        super("Author or room with not found in tables");
    }
}
