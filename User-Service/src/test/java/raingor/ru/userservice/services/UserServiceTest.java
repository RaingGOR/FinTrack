package raingor.ru.userservice.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import raingor.ru.userservice.FakeDomain;
import raingor.ru.userservice.domain.User;
import raingor.ru.userservice.dtos.FullUserDTO;
import raingor.ru.userservice.dtos.UserDTO;
import raingor.ru.userservice.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    private User fakeUser;

    @BeforeEach
    void init() {
        fakeUser = FakeDomain.getUser();
    }

    @Test
    void getUserDTO_returnUserDTO() {
        when(userRepository.findById(fakeUser.getId())).thenReturn(Optional.ofNullable(fakeUser));

        UserDTO testedUserDTO = userService.getUserDTO(fakeUser.getId());
        UserDTO fakeUserDTO = new UserDTO(fakeUser.getUsername(), fakeUser.getEmail());

        assertEquals(fakeUserDTO, testedUserDTO);
    }

    @Test
    void getAllUsers() {
        when(userRepository.findAll()).thenReturn(List.of(fakeUser));

        List<FullUserDTO> testedUsers = userService.getAllUsers();
        List<UserDTO> fakeUsers = List.of(fakeUser).stream()
                .map(x -> new UserDTO(x.getUsername(), x.getEmail())).toList();

        assertEquals(fakeUsers, testedUsers);
    }

    @Test
    void createUser() {
        userService.createUser(new UserDTO(fakeUser.getUsername(), fakeUser.getEmail()));

        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    void updateUser() {
        when(userRepository.findById(1L)).thenReturn(Optional.of(fakeUser));

        userService.updateUser(fakeUser.getId(), new UserDTO("updatedUsername", "updatedEmail"));

        verify(userRepository, times(1)).save(any(User.class));
        assertEquals("updatedUsername", fakeUser.getUsername());
        assertEquals("updatedEmail", fakeUser.getEmail());
    }

    @Test
    void deleteUser() {
        when(userRepository.findById(1L)).thenReturn(Optional.of(fakeUser));

        userService.deleteUser(fakeUser.getId());

        verify(userRepository, times(1)).delete(any(User.class));
    }
}