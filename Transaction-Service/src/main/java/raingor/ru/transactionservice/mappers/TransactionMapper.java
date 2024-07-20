package raingor.ru.transactionservice.mappers;

import raingor.ru.transactionservice.domain.Transaction;
import raingor.ru.transactionservice.dtos.FullTransactionDTO;

public class TransactionMapper {
    public static FullTransactionDTO TransactionToFullTransactionDTOMapper(Transaction transaction) {
        if (transaction == null) {
            return null;
        }
        return new FullTransactionDTO(
                transaction.getId(),
                transaction.getSender_id(),
                transaction.getRecipient_id(),
                transaction.getDate(),
                transaction.getAmount(),
                transaction.getDescription(),
                transaction.getType().name(),
                transaction.getStatus().name()
        );
    }
}
