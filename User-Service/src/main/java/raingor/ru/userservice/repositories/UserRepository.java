package raingor.ru.userservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import raingor.ru.userservice.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
