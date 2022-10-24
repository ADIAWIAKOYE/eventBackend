package eventticket.com.event.repository;

import eventticket.com.event.modele.Evennement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface EvennementRepo extends JpaRepository<Evennement, Long> {

    Evennement findByIdevent(Long idevent);

    Evennement findByNomevent(String nom);

    Evennement findByDateStart(Date dateStart);
}
