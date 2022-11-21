package eventticket.com.event.services;

import eventticket.com.event.message.ReponseMessage;
import eventticket.com.event.modele.CategorieTicket;
import eventticket.com.event.modele.Ticket;
import eventticket.com.event.repository.EvennementRepo;
import eventticket.com.event.repository.TicketRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ClientServiceImpl implements ClientService{

    @Autowired
    private TicketRepo ticketRepo;

    @Override
    public ReponseMessage acheterTicket(Ticket ticket) {
        return null;
    }

    @Override
    public List<CategorieTicket> afficherTicket() {
        return null;
    }
}
