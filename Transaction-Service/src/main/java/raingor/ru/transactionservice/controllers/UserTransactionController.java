package raingor.ru.transactionservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/transaction-api/user-transactions/{id}")
public class UserTransactionController {
    //выдача транзакций по определенным меткам

}
