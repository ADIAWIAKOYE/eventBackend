package eventticket.com.event.repository;

import eventticket.com.event.modele.Avis;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvisRepo extends JpaRepository<Avis, Long> {
}
