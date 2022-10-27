package eventticket.com.event.repository;

import eventticket.com.event.modele.CategorieTicket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategorieTicketRepo extends JpaRepository<CategorieTicket, Long> {

    CategorieTicket findByIdcategorie(Long idcategorie);

    List <CategorieTicket> findByDescription(String description);
}
