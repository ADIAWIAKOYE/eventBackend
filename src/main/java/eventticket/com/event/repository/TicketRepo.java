package eventticket.com.event.repository;

import eventticket.com.event.modele.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepo extends JpaRepository<Ticket, Long> {

    Ticket findByIdticket(Long idticket);

    Ticket findByNumserie(String numserie);
}
