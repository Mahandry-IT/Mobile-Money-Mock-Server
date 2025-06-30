package papi.mobilemoney.mock.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;
import papi.mobilemoney.mock.data.dto.error.MocServerError;
import papi.mobilemoney.mock.data.dto.error.MobileMoneyTokenError;
import papi.mobilemoney.mock.data.exception.MobileMoneyException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<MocServerError> handleGeneral(Exception ex, HttpServletRequest request) {
        MocServerError error = new MocServerError(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "An error has occurred.",
                ex.getMessage(),
                request.getRequestURI()
        );
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<MocServerError> handleNoHandlerFound(NoResourceFoundException ex, HttpServletRequest request) {
        MocServerError error = new MocServerError(
                HttpStatus.NOT_FOUND.value(),
                "Resource not found",
                ex.getMessage(),
                request.getRequestURI()
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(MobileMoneyException.class)
    public ResponseEntity<MobileMoneyTokenError> handleMobileMoneyError(MobileMoneyException ex) {
        MobileMoneyTokenError error = new MobileMoneyTokenError(
                ex.getMessage(),
                ex.getTitle()
        );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
