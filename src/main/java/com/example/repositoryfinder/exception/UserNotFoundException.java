package com.example.repositoryfinder.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "404 User Not Found")
public class UserNotFoundException extends RuntimeException {
}