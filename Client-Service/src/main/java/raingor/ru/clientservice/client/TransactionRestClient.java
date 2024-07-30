package raingor.ru.clientservice.client;

import raingor.ru.clientservice.dtos.TransactionDTO;

import java.util.List;

public interface TransactionRestClient {
    List<TransactionDTO> getTransactions();

}
