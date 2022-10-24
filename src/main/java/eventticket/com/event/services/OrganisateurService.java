package eventticket.com.event.services;

import eventticket.com.event.message.ReponseMessage;
import eventticket.com.event.modele.Evennement;

import java.util.Date;
import java.util.List;

public interface OrganisateurService {

    //================METHODE PERMETTANT D'AJOUTER UN EVENNEMENT=========================
    ReponseMessage ajouterEvent(Evennement evennement, String idacteur, String nomlieu);

    //================METHODE PERMETTANT DE MODIFIER UN EVENNEMENT=========================
    ReponseMessage modifierEvent(Evennement evennement, Long idevent);

    //================METHODE PERMETTANT DE SUPPRIMER UN EVENNEMENT=========================
    ReponseMessage supprimerEvent(Long idevent);

    //================METHODE PERMETTANT D'AFFICHER LA LISTE DES EVENNEMENTS=========================
    List<Evennement> afficherEvent();

    //================METHODE PERMETTANT DE RETROUVER UN EVENNEMENT PAR SON ID=========================
    Evennement trouverEventParId(Long idevent);

    //================METHODE PERMETTANT DE RETROUVER UN EVENNEMENT PAR SON NOM=========================
    Evennement trouverEventParNom(String nomevent);

    Evennement truverEventParDateStart(Date dateStart);
}
