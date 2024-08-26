package raingor.ru.clientservice.services;

import org.springframework.stereotype.Service;
import raingor.ru.clientservice.client.impl.TransactionRestClientImpl;
import raingor.ru.clientservice.dtos.TransactionDTO;

import java.util.List;

@Service
public class TransactionService {
    private final TransactionRestClientImpl transactionRestClient;

    public TransactionService(TransactionRestClientImpl transactionRestClient) {
        this.transactionRestClient = transactionRestClient;
    }

    public List<TransactionDTO> getAllTransactions() {
        return transactionRestClient.getTransactions();
    }
}
