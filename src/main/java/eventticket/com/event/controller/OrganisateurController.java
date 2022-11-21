package eventticket.com.event.controller;

import eventticket.com.event.Image.ComfigImage;
import eventticket.com.event.message.ReponseMessage;
import eventticket.com.event.modele.CategorieTicket;
import eventticket.com.event.modele.Evennement;
import eventticket.com.event.modele.User;
import eventticket.com.event.services.OrganisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
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

    //================DEBUT DE LA METHODE PERMETTANT DE MODIFIER UN EVENNEMENT=========================
    @PutMapping("/modifierEvent/{idevent}")
    public ReponseMessage modifierEvent(Evennement evennement, Long idevent){

        return organisateurService.modifierEvent(evennement, idevent);
    }//================FIN DE LA METHODE PERMETTANT DE MODIFIER UN EVENNEMENT=========================

    //================DEBUT DE LA METHODE PERMETTANT DE SUPPRIMER UN EVENNEMENT=========================
    @DeleteMapping("/supprimerEvent/{idevent}")
    public ReponseMessage supprimerEvent(Long idevent) {

        return organisateurService.supprimerEvent(idevent);
    }//================FIN DE LA METHODE PERMETTANT DE SUPPRIMER UN EVENNEMENT=========================

    //================DEBUT DE LA METHODE PERMETTANT D'AFFICHER LES EVENNEMENTS DE LA BASE DE DONNER=========================
    @GetMapping("/afficherEvent")
    public List<Evennement> afficherEvent() {

        return organisateurService.afficherEvent();
    }//=================FIN DE LA METHODE PERMETTANT D'AFFICHER LES EVENNEMENTS DE LA BASE DE DONNER=========================

    @PostMapping("/ajouterEvent2/{nomlieu}/{idacteur}/{nbreTicketDispo}")
    public ReponseMessage creerEvent2(@Param("nomevent") String nomevent, @Param("desciption") String desciption, @Param("dateStart") LocalDate dateStart
            , @Param("timeStart") LocalTime timeStart, @Param("dateEnd") LocalDate dateEnd, @Param("timeEnd") LocalTime timeEnd, @PathVariable("nbreTicketDispo") int nbreTicketDispo
            ,@Param("categorie") String categorie, @Param("file") MultipartFile fileUser , @PathVariable String idacteur, @PathVariable String nomlieu)throws IOException {
        Evennement evennement = new Evennement();
        System.out.println("le nom1 de l'evennement est "+fileUser);
        String nomfileEvent = StringUtils.cleanPath(fileUser.getOriginalFilename());
        evennement.setNomevent(nomevent);
        evennement.setDesciption(desciption);
        evennement.setDateStart(dateStart);
        evennement.setDateEnd(dateEnd);
        evennement.setTimeStart(timeStart);
        evennement.setTimeEnd(timeEnd);
        evennement.setNbreTicketDispo(nbreTicketDispo);
        evennement.setCategorie(categorie);
        System.out.println("le nom1 de l'evennement est "+nomfileEvent);
        evennement.setAffiche(nomfileEvent);
        String uploaDirEvent = "src/main/resources/fileEvent/";
        ComfigImage.saveimgEvent(uploaDirEvent, nomfileEvent, fileUser);
        return organisateurService.ajouterEvent(evennement, idacteur, nomlieu);
    }

    @PostMapping("/ajouterCategorieTicket/{idevent}")
    public ReponseMessage ajouterCategorieTicket(@RequestBody CategorieTicket categorieTicket, @PathVariable Long idevent) {

        return organisateurService.ajouterCategorieTicket(categorieTicket, idevent);
    }

    @PutMapping("/modifierCategorieTicket/{idcategorie}")
    public ReponseMessage modifierCategorieTicket(@RequestBody CategorieTicket categorieTicket, @PathVariable Long idcategorie) {

        return organisateurService.modifierCategorieTicket(categorieTicket, idcategorie);
    }

    @DeleteMapping("/supprimerCategorieTicket/{idcategorie}")
    public ReponseMessage supprimerCategorieTicket(@PathVariable Long idcategorie) {

        return organisateurService.supprimerCategorieTicket(idcategorie);
    }

    @GetMapping("/afficherCategorieTicket")
    public List<CategorieTicket> afficherCategorieTicket() {

     return organisateurService.afficherCategorieTicket();
    }
}
