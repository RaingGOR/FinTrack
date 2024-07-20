package raingor.ru.transactionservice.dtos;

import java.time.LocalDateTime;

public record FullTransactionDTO(
        Long id,
        Long sender_id,
        Long recipient_id,
        LocalDateTime date,
        Double amount,
        String description,
        String type,
        String status
) {
}
