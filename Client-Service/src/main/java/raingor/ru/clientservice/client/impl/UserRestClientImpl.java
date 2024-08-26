package raingor.ru.clientservice.client.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import raingor.ru.clientservice.client.UserRestClient;
import raingor.ru.clientservice.dtos.UserDTO;

import java.util.List;

@Component
public class UserRestClientImpl implements UserRestClient {
    private final WebClient.Builder webClientBuilder;
    private final LoadBalancerClient loadBalancerClient;
    private static final ParameterizedTypeReference<List<UserDTO>> USER_LIST_TYPE =
            new ParameterizedTypeReference<List<UserDTO>>() {
            };


    @Autowired
    public UserRestClientImpl(WebClient.Builder webClientBuilder, LoadBalancerClient loadBalancerClient) {
        this.webClientBuilder = webClientBuilder;
        this.loadBalancerClient = loadBalancerClient;
    }


    @Override
    public List<UserDTO> getUsers() {
        ServiceInstance instance = loadBalancerClient.choose("User-Service");
        if (instance == null) {
            throw new RuntimeException("No instances available for User-Service");
        }
        String url = instance.getUri().toString();

        return this.webClientBuilder
                .baseUrl(url)
                .build()
                .get()
                .uri("/user-api/users")
                .retrieve()
                .bodyToMono(USER_LIST_TYPE)
                .block();
    }
}
