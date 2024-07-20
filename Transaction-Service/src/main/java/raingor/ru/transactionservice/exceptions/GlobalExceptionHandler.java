package raingor.ru.transactionservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({NotFoundTransactionException.class})
    public ResponseEntity<ErrorResponse> handleException(NotFoundTransactionException e) {
        ErrorResponse response = new ErrorResponse(
                "Transaction not found",
                System.currentTimeMillis(),
                LocalDateTime.now()
        );

        //return 404
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

}
