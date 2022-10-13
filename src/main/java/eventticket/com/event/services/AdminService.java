package eventticket.com.event.services;

import eventticket.com.event.message.ReponseMessage;
import eventticket.com.event.modele.Etat;
import eventticket.com.event.modele.Role;
import eventticket.com.event.modele.User;

import java.util.List;


public interface AdminService {

    //================METHODE PERMETTANT D'AJOUTER UN ROLE=========================
    ReponseMessage ajouterRole(Role role);


    //================METHODE PERMETTANT DE MODIFIER UN ROLE=========================
    ReponseMessage modifierRole(Role role, Long idrole);

    //================METHODE PERMETTANT D'AFFICHER LES ROLES QUI SE TROUVES DANS LA BASE DE DONNER=========================
    List<Role> afficherRole();

    //================METHODE PERMETTANT DE SUPPRIMER UN ROLE=========================
    ReponseMessage supprimerRole(Long idrole);


    //================METHODE PERMETTANT DE RECUPERER L'IDENTIFIANT D'UN ROLE=========================
    Role trouverRoleParId(Long idrole);



    //================METHODE PERMETTANT D'AJOUTER UN USER=========================

    ReponseMessage ajouterUtilisateurU(User user, String nomrole);

    //================METHODE PERMETTANT DE MODIFIER UN USER=========================
    ReponseMessage modifierUtilisateur(User user, Long iduser);

    //================METHODE PERMETTANT D'AFFICHER UN USER=========================
    List<User> afficherUtilisateur();

    //================METHODE PERMETTANT DE SUPPRIMER UN USER=========================
    ReponseMessage supprimerUtilisateur(Long iduser);

    //================METHODE PERMETTANT A UN USER DE SE CONNECTER =========================
    Object seConnecter(String email, String password);

    //================METHODE PERMETTANT DE RETROUVER UN USER PAR SON IDENTIFIANT =========================
    User trouverUtilisateurParId(Long id);



    //================METHODE PERMETTANT D'AJOUTER UN ETAT=========================
    ReponseMessage ajouterEtat(Etat etat);

    //================METHODE PERMETTANT DE MODIFIER UN ETAT=========================
    ReponseMessage modifierEtat(Etat etat, Long idetat);

    //================METHODE PERMETTANT DE SUPPRIMER UN ETAT=========================
    ReponseMessage supprimerEtat(Long id);

    //================METHODE PERMETTANT D'AFFICHER UN ETAT=========================
    List<Etat> afficherEtat();

    //================METHODE PERMETTANT DE RETROUVER UN ETAT PAR SON ID=========================
    Etat trouverEtatParId(Long idetat);

    //================METHODE PERMETTANT DE RETROUVER UN ETAT PAR SON CONTENU=========================
    Etat trouverEtatParContenu(String contenu);
}
