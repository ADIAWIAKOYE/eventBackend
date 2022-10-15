package eventticket.com.event.services;

import eventticket.com.event.message.ReponseMessage;
import eventticket.com.event.modele.*;

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



    //================METHODE PERMETTANT D'AJOUTER UN ACTEUR=========================
    ReponseMessage ajouterActeur(Acteur acteur);

    //================METHODE PERMETTANT DE MODIFIER UN ACTEUR=========================
    ReponseMessage modifierActeur(Acteur acteur, Long idacteur);

    //================METHODE PERMETTANT DE SUPPRIMER UN ACTEUR=========================
    ReponseMessage supprimerActeur(Long id);

    //================METHODE PERMETTANT D'AFFICHER UN ACTEUR=========================
    List<Acteur> afficherActeur();

    //================METHODE PERMETTANT DE RETROUVER UN ACTEUR PAR SON ID=========================
    Acteur trouverActeurParid(Long idacteur);

    //================METHODE PERMETTANT DE RETROUVER UN ACTEUR PAR SON NOM=========================
    Acteur trouverActeurParNom(String nom);


    //================METHODE PERMETTANT D'AJOUTER UN LIEU=========================
    ReponseMessage ajouterLieu(Lieu lieu);

    //================METHODE PERMETTANT DE MODIFIER UN LIEU=========================
    ReponseMessage modifierLieu(Lieu lieu, Long idlieu);

    //================METHODE PERMETTANT DE SUPPRIMER UN LIEU=========================
    ReponseMessage supprimerLieu(Long id);

    //================METHODE PERMETTANT D'AFFICHER LES LIEUS DE LA BASE DE DONNER=========================
    List<Lieu> afficherLieu();

    //================METHODE PERMETTANT DE RETROUVER UN LIEU PAR SON ID=========================
    Lieu trouverLieuParid(Long idlieu);

    //================METHODE PERMETTANT DE RETROUVER UN LIEU PAR SON NOM=========================
    Lieu trouverLieuParNom(String nom);
}
