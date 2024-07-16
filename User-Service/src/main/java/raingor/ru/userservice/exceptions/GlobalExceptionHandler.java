package raingor.ru.userservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({NotFoundUserException.class})
    public ResponseEntity<ErrorResponse> handleException(NotFoundUserException e) {
        ErrorResponse response = new ErrorResponse(
                "User not found",
                System.currentTimeMillis(),
                LocalDateTime.now()
        );

        //return 404
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

}
