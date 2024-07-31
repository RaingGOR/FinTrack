package raingor.ru.clientservice.config;

import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import raingor.ru.clientservice.client.TransactionRestClient;
import raingor.ru.clientservice.client.TransactionRestClientImpl;

@Configuration
public class AppConfig {


    @Bean
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder();
    }

    @Bean
    public TransactionRestClient transactionRestClient(WebClient.Builder webClientBuilder, LoadBalancerClient loadBalancerClient) {
        return new TransactionRestClientImpl(webClientBuilder, loadBalancerClient);
    }
}
