package raingor.ru.userservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import raingor.ru.userservice.dto.UserDTO;
import raingor.ru.userservice.exceptions.NotFoundUserException;
import raingor.ru.userservice.model.User;
import raingor.ru.userservice.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserDTO getUserDTO(Long id) {
        User user = userRepository.findById(id).orElseThrow(NotFoundUserException::new);
        return new UserDTO(user.getUsername(), user.getEmail());
    }

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream().map(x -> new UserDTO(x.getUsername(), x.getEmail()))
                .collect(Collectors.toList());
    }

    public void createUser(UserDTO userDTO) {
        userRepository.save(new User(userDTO.username(), userDTO.email()));
    }

    public void updateUser(Long id, UserDTO updatedUser) {
        User user = userRepository.findById(id).orElseThrow(NotFoundUserException::new);
        user.setUsername(StringUtils.hasText(updatedUser.username()) ? updatedUser.username() : user.getUsername());
        user.setEmail(StringUtils.hasText(updatedUser.email()) ? updatedUser.email() : user.getEmail());
        userRepository.save(user);
    }

    public void deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(NotFoundUserException::new);
        userRepository.delete(user);
    }
}