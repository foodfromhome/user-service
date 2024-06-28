package org.homefood.userservice.service.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String email) {}
}
