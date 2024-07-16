package raingor.ru.userservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import raingor.ru.userservice.dto.UserDTO;
import raingor.ru.userservice.exceptions.NotFoundUserException;
import raingor.ru.userservice.model.User;
import raingor.ru.userservice.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserDTO getUserDTO(Long id) {
        User user = userRepository.findById(id).orElseThrow(NotFoundUserException::new);
        return new UserDTO(user.getName(), user.getEmail());
    }
}
