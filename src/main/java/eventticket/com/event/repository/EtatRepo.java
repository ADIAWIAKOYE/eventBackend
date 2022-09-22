package eventticket.com.event.repository;

import eventticket.com.event.modele.Etat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtatRepo extends JpaRepository<Etat, Long> {
}
