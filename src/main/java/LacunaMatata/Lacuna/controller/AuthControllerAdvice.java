package LacunaMatata.Lacuna.controller;

import LacunaMatata.Lacuna.exception.InactiveAccountException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AuthControllerAdvice {

    @ExceptionHandler(InactiveAccountException.class)
    public ResponseEntity<?> InactiveAccountException(InactiveAccountException e) {
        return ResponseEntity.status(401).body(e.getErrorMessages());
    }

}
