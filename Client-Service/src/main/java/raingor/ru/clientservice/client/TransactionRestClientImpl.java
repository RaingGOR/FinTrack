package raingor.ru.clientservice.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.ParameterizedTypeReference;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import raingor.ru.clientservice.dtos.TransactionDTO;

import java.util.List;


@Component
public class TransactionRestClientImpl implements TransactionRestClient {
    private final WebClient.Builder webClientBuilder;
    private final LoadBalancerClient loadBalancerClient;
    private static final ParameterizedTypeReference<List<TransactionDTO>> TRANSACTION_LIST_TYPE
            = new ParameterizedTypeReference<List<TransactionDTO>>() {
    };

    @Autowired
    public TransactionRestClientImpl(WebClient.Builder webClientBuilder, LoadBalancerClient loadBalancerClient) {
        this.webClientBuilder = webClientBuilder;
        this.loadBalancerClient = loadBalancerClient;
    }

    @Override
    public List<TransactionDTO> getTransactions() {
        ServiceInstance instance = loadBalancerClient.choose("Transaction-Service");
        if (instance == null) {
            throw new IllegalStateException("No instances available for Transaction-Service");
        }
        String baseUrl = instance.getUri().toString();

        return this.webClientBuilder
                .baseUrl(baseUrl)
                .build()
                .get()
                .uri("/transaction-api/transactions")
                .retrieve()
                .bodyToMono(TRANSACTION_LIST_TYPE)
                .block();
    }
}
