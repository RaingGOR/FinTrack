package raingor.ru.transactionservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import raingor.ru.transactionservice.services.TransactionService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/transaction-api/transactions")
public class TransactionController {
    private final TransactionService transactionService;

    @GetMapping
    public ResponseEntity<?> getTransactions() {
        return transactionService.getAllTransactions();
    }
}
