package raingor.ru.transactionservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import raingor.ru.transactionservice.domain.Transaction;
import raingor.ru.transactionservice.domain.TransactionStatus;
import raingor.ru.transactionservice.domain.TransactionType;
import raingor.ru.transactionservice.dtos.CreatedTransactionDTO;
import raingor.ru.transactionservice.dtos.FullTransactionDTO;
import raingor.ru.transactionservice.dtos.UpdatedTransactionDTO;
import raingor.ru.transactionservice.exceptions.NotFoundTransactionException;
import raingor.ru.transactionservice.mappers.TransactionMapper;
import raingor.ru.transactionservice.repositories.TransactionRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;

    public List<FullTransactionDTO> getAllTransactions() {
        return transactionRepository.findAll().stream()
                .map(TransactionMapper::TransactionToFullTransactionDTOMapper).toList();
    }

    public FullTransactionDTO getTransaction(Long id) {
        return transactionRepository.findById(id).map(TransactionMapper::TransactionToFullTransactionDTOMapper)
                .orElseThrow(NotFoundTransactionException::new);
    }

    public void createNewTransaction(CreatedTransactionDTO createdTransactionDTO) {
        Transaction transaction = new Transaction(
                createdTransactionDTO.sender_id(),
                createdTransactionDTO.recipient_id(),
                LocalDateTime.now(),
                createdTransactionDTO.amount(),
                createdTransactionDTO.description(),
                TransactionType.valueOf(createdTransactionDTO.type()),
                TransactionStatus.valueOf(createdTransactionDTO.status())
        );

        transactionRepository.save(transaction);
    }

    public void updateTransaction(Long id, UpdatedTransactionDTO updatedTransaction) {
        Transaction transaction = transactionRepository.findById(id).orElseThrow(NotFoundTransactionException::new);

        transaction.setSender_id(updatedTransaction.sender_id());
        transaction.setRecipient_id(updatedTransaction.recipient_id());
        transaction.setAmount(updatedTransaction.amount());
        transaction.setDescription(updatedTransaction.description());
        transaction.setType(TransactionType.valueOf(updatedTransaction.type()));
        transaction.setStatus(TransactionStatus.valueOf(updatedTransaction.status()));

        transactionRepository.save(transaction);
    }

    public void deleteTransaction(Long id) {
        //check found transaction
        Transaction transaction = transactionRepository.findById(id).orElseThrow(NotFoundTransactionException::new);

        transactionRepository.deleteById(id);
    }
}
