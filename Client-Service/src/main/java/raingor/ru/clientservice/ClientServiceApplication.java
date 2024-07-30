package raingor.ru.clientservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import com.vaadin.flow.component.page.AppShellConfigurator;

@SpringBootApplication
@EnableDiscoveryClient
public class ClientServiceApplication implements AppShellConfigurator {

    public static void main(String[] args) {
        SpringApplication.run(ClientServiceApplication.class, args);
    }
}
