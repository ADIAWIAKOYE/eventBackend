package eventticket.com.event.repository;

import eventticket.com.event.modele.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {
}
