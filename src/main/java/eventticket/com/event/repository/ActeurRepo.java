package eventticket.com.event.repository;

import eventticket.com.event.modele.Acteur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActeurRepo extends JpaRepository<Acteur, Long> {
}
