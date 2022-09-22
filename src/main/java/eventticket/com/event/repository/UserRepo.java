package eventticket.com.event.repository;

import eventticket.com.event.modele.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
