package eventticket.com.event.repository;

import eventticket.com.event.modele.Evennement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface EvennementRepo extends JpaRepository<Evennement, Long> {

    Evennement findByIdevent(Long idevent);

   List <Evennement> findByNomevent(String nomevent);

    Evennement findByDateStart(LocalDate dateStart);

    Evennement findByNomeventAndDateStart(String nomevent, Date dateStart);
}
