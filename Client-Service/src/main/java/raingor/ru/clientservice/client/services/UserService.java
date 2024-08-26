package raingor.ru.clientservice.client.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import raingor.ru.clientservice.client.impl.UserRestClientImpl;
import raingor.ru.clientservice.client.dtos.UserDTO;

import java.util.List;

@Service
public class UserService {
    private final UserRestClientImpl userRestClient;

    @Autowired
    public UserService(UserRestClientImpl userRestClient) {
        this.userRestClient = userRestClient;
    }

    public List<UserDTO> getAllUsers() {
        return userRestClient.getUsers();
    }
}
