package eventticket.com.event.controller;

import eventticket.com.event.message.ReponseMessage;
import eventticket.com.event.modele.Evennement;
import eventticket.com.event.services.OrganisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/organisateur")
public class OrganisateurController {

    @Autowired
    private OrganisateurService organisateurService;

    @PostMapping("/ajouterEvent/{nomlieu}/{idacteur}")
    public ReponseMessage ajouterEvent(@RequestBody Evennement evennement, @PathVariable String idacteur, @PathVariable String nomlieu) {

        return organisateurService.ajouterEvent(evennement, idacteur, nomlieu);
    }

    @PutMapping("/modifierEvent/{idevent}")
    public ReponseMessage modifierEvent(Evennement evennement, Long idevent){

        return organisateurService.modifierEvent(evennement, idevent);
    }

    @DeleteMapping("/supprimerEvent/{idevent}")
    public ReponseMessage supprimerEvent(Long idevent) {

        return organisateurService.supprimerEvent(idevent);
    }

    @GetMapping("/afficherEvent")
    public List<Evennement> afficherEvent() {

        return organisateurService.afficherEvent();
    }
}
