package eventticket.com.event.repository;

import eventticket.com.event.modele.CategorieTicket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieTicketRepo extends JpaRepository<CategorieTicket, Long> {

    CategorieTicket findByIdcategorie(Long idcategorie);

    CategorieTicket findByDescription(String description);
}
