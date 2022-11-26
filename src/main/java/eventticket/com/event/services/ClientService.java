package eventticket.com.event.services;

import eventticket.com.event.message.ReponseMessage;
import eventticket.com.event.modele.CategorieTicket;
import eventticket.com.event.modele.Ticket;

import java.util.List;

public interface ClientService {

    ReponseMessage acheterTicket(Ticket ticket, Long id);

    List<CategorieTicket> afficherTicket();
}
