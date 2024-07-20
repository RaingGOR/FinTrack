package raingor.ru.transactionservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import raingor.ru.transactionservice.dtos.CreatedTransactionDTO;
import raingor.ru.transactionservice.dtos.UpdatedTransactionDTO;
import raingor.ru.transactionservice.services.TransactionService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/transaction-api/transactions")
public class TransactionsController {
    private final TransactionService transactionService;

    @GetMapping
    public ResponseEntity<?> getTransactions() {
        return new ResponseEntity<>(transactionService.getAllTransactions(), HttpStatus.OK);
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
            , @RequestBody UpdatedTransactionDTO updatedTransaction){
        transactionService.updateTransaction(id, updatedTransaction);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTransaction(@PathVariable Long id) {
        transactionService.deleteTransaction(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
