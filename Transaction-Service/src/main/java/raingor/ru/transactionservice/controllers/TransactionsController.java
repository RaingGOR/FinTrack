package raingor.ru.transactionservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import raingor.ru.transactionservice.dtos.CreatedTransactionDTO;
import raingor.ru.transactionservice.dtos.UpdatedTransactionDTO;
import raingor.ru.transactionservice.services.TransactionService;

import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
@RequestMapping("/transaction-api/transactions")
public class TransactionsController {
    private final TransactionService transactionService;

    // используется теперь вместо findAllTransaction, ведь без фильтров по сути выдает все транзации
    @GetMapping()
    public ResponseEntity<?> getFilteredListTransactions(@RequestParam(required = false) Long senderId,
                                                         @RequestParam(required = false) Long recipientId,
                                                         @RequestParam(required = false) LocalDateTime date,
                                                         @RequestParam(required = false) Double amount,
                                                         @RequestParam(required = false) String description,
                                                         @RequestParam(required = false) String type,
                                                         @RequestParam(required = false) String status) {
        return new ResponseEntity<>(
                transactionService.getFilteredTransactions(senderId, recipientId, date, amount,
                        description, type, status), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTransaction(@PathVariable Long id) {
        return new ResponseEntity<>(transactionService.getTransaction(id), HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity<?> createTransaction(@RequestBody CreatedTransactionDTO transaction) {
        transactionService.createNewTransaction(transaction);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateTransaction(@PathVariable Long id
            , @RequestBody UpdatedTransactionDTO updatedTransaction) {
        transactionService.updateTransaction(id, updatedTransaction);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTransaction(@PathVariable Long id) {
        transactionService.deleteTransaction(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
