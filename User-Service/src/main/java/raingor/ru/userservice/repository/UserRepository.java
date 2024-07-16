package raingor.ru.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import raingor.ru.userservice.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
