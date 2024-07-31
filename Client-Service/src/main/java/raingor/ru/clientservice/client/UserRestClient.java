package raingor.ru.clientservice.client;

import raingor.ru.clientservice.dtos.UserDTO;

import java.util.List;

public interface UserRestClient {
    List<UserDTO> getUsers();
}
