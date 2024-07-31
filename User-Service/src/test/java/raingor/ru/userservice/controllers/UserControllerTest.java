package raingor.ru.userservice.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import raingor.ru.userservice.dtos.FullUserDTO;
import raingor.ru.userservice.dtos.UserDTO;
import raingor.ru.userservice.exceptions.NotFoundUserException;
import raingor.ru.userservice.services.UserService;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {
    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    void getAllUsers() throws Exception {
        when(userService.getAllUsers()).thenReturn(List.of(new FullUserDTO("", "", "")));

        mockMvc.perform(get("/user-api/users"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(1)));
    }

    @Test
    void getUser() throws Exception {
        when(userService.getUserDTO(1L)).thenReturn(new UserDTO("", ""));

        mockMvc.perform(get("/user-api/users/{id}", 1L))
                .andExpect(status().isFound());
    }

    @Test
    void addUser() throws Exception {
        UserDTO userDTO = new UserDTO("John", "Doe");

        mockMvc.perform(post("/user-api/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(userDTO)))
                .andExpect(status().isCreated());
    }

    @Test
    void updateUser_success() throws Exception {
        UserDTO updatedUser = new UserDTO("NewUsername", "newemail@example.com");

        mockMvc.perform(patch("/user-api/users/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatedUser)))
                .andExpect(status().isOk());

    }

    @Test
    void updateUser_userNotFound() throws Exception {
        UserDTO updatedUser = new UserDTO("NewUsername", "newemail@example.com");

        doThrow(new NotFoundUserException()).when(userService).updateUser(1L, updatedUser);

        mockMvc.perform(patch("/user-api/users/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatedUser)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void deleteUser() throws Exception {
        mockMvc.perform(delete("/user-api/users/{id}", 1L))
                .andExpect(status().isOk());

        verify(userService, times(1)).deleteUser(1L);

    }
}