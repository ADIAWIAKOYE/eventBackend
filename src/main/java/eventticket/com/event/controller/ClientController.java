package eventticket.com.event.controller;


import eventticket.com.event.message.ReponseMessage;
import eventticket.com.event.modele.Ticket;
import eventticket.com.event.services.ClientService;
import eventticket.com.event.services.OrganisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;


    @PostMapping("/acheter/{id}")
    public ReponseMessage acheterTicket(@RequestBody Ticket ticket, @PathVariable Long id) {

        return clientService.acheterTicket(ticket, id);
    }
}
