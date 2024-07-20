package raingor.ru.transactionservice.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private String message;
    private Long timestamp;
    private LocalDateTime localDateTime;
}
