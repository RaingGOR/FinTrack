package raingor.ru.transactionservice.dtos;


public record UpdatedTransactionDTO(
        Long sender_id,
        Long recipient_id,
        Double amount,
        String description,
        String type,
        String status
){
}
