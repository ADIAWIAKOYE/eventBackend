package eventticket.com.event.services;

import eventticket.com.event.message.ReponseMessage;
import eventticket.com.event.modele.CategorieTicket;
import eventticket.com.event.modele.Ticket;
import eventticket.com.event.repository.CategorieTicketRepo;
import eventticket.com.event.repository.EvennementRepo;
import eventticket.com.event.repository.TicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class ClientServiceImpl implements ClientService{

    @Autowired
    private TicketRepo ticketRepo;

    @Autowired
    private CategorieTicketRepo categorieTicketRepo;

    @Autowired
    private EvennementRepo evennementRepo;

    @Override
    public ReponseMessage acheterTicket(Ticket ticket, Long id) {
        if (categorieTicketRepo.findByIdcategorie(id) != null) {
//            ticket.setValiderticket(true);
            ticket.setDateachat(new Date());

            //   CategorieTicket categorieTicket = new CategorieTicket();
                CategorieTicket categorieTicket = categorieTicketRepo.findByIdcategorie(id);
                ticket.setCategorieTicket(categorieTicket);
            String er = ticket.getCategorieTicket().getEvennement().getNomevent().substring(0,2);
            int an = ticket.getCategorieTicket().getEvennement().getDateStart().getYear();
            int mo = ticket.getCategorieTicket().getEvennement().getDateStart().getMonthValue();
            int day = ticket.getCategorieTicket().getEvennement().getDateStart().getDayOfMonth();
            String cat = ticket.getCategorieTicket().getDescription();
            ticket.setNumserie(er + an + mo + day + cat);
            Random r = new Random();
            for (int i = 0; i < 10; i++) {

            int nombre = (r.nextInt(10));

            ticket.setNumserie(ticket.getNumserie() + nombre);

            String u = er + an + mo + day + cat + nombre;
         //   System.out.println(er);
           //    System.out.println("le numero de serie est "+ticket.getNumserie());
           }


            System.out.println("le numero de serie est "+ticket.getNumserie());


            //ticketRepo.save(ticket);

            System.out.println();
            ReponseMessage message = new ReponseMessage("Ticket acheter avec succes", true);
            return message;

        } else {
            ReponseMessage message = new ReponseMessage("Cet ticket n'existe pas ", false);

            return message;

        }
    }
    @Override
    public List<CategorieTicket> afficherTicket() {
        return null;
    }
}
