package eventticket.com.event.repository;

import eventticket.com.event.modele.Lieu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LieuRepo extends JpaRepository<Lieu, Long> {
}
