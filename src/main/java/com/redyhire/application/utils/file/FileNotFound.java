package com.redyhire.application.utils.file;

public class FileNotFound extends RuntimeException{
    public FileNotFound(String message) {
        super(message);
    }
    public FileNotFound(String message, Throwable throwable) {
        super(message, throwable);
    }
}
