package raingor.ru.userservice.dtos;

public record FullUserDTO(
        Long id,
        String username,
        String email,
        String password
) {
}
