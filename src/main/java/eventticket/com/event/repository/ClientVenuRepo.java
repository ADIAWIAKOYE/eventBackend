package eventticket.com.event.repository;

import eventticket.com.event.modele.ClientVenu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientVenuRepo extends JpaRepository<ClientVenu, Long> {
}
