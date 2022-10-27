package eventticket.com.event.services;

import eventticket.com.event.message.ReponseMessage;
import eventticket.com.event.modele.CategorieTicket;
import eventticket.com.event.modele.Evennement;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface OrganisateurService {

    //================METHODE PERMETTANT D'AJOUTER UN EVENNEMENT=========================
    ReponseMessage ajouterEvent(Evennement evennement, String idacteur, String nomlieu);
    //ReponseMessage ajouterEventE(Evennement evennement, String nomevent, String idacteur, String nomlieu);

    //================METHODE PERMETTANT DE MODIFIER UN EVENNEMENT=========================
    ReponseMessage modifierEvent(Evennement evennement, Long idevent);

    //================METHODE PERMETTANT DE SUPPRIMER UN EVENNEMENT=========================
    ReponseMessage supprimerEvent(Long idevent);

    //================METHODE PERMETTANT D'AFFICHER LA LISTE DES EVENNEMENTS=========================
    List<Evennement> afficherEvent();

    //================METHODE PERMETTANT DE RETROUVER UN EVENNEMENT PAR SON ID=========================
    Evennement trouverEventParId(Long idevent);

    //================METHODE PERMETTANT DE RETROUVER UN EVENNEMENT PAR SON NOM=========================
    List<Evennement> trouverEventParNom(String nomevent);

    Evennement trouverEventParNomDateStart(String nomevent, Date dateStart);

    Evennement truverEventParDateStart(LocalDate dateStart);

    //===============FIN DE LA GESTION DES EVENNEMENTS =========================


    //===============DEBUT DE LA GESTION DES CATEGORIETICKETS =========================

    ReponseMessage ajouterCategorieTicket(CategorieTicket categorieTicket, Long idevent);

    ReponseMessage modifierCategorieTicket(CategorieTicket categorieTicket, Long idcategorie);

    ReponseMessage supprimerCategorieTicket(Long idcategorie);

    List<CategorieTicket> afficherCategorieTicket();

    CategorieTicket trouverCategorieTicketParid(Long idcategorie);

    List <CategorieTicket> trouverCategorieTicketParNom(String categorie);
}
