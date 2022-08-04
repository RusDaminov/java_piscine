package edu.school21.chat.repositories;

public class NotSavedSubEntityException extends RuntimeException{
    NotSavedSubEntityException() {
        super("Author or room with not found in tables");
    }
}
