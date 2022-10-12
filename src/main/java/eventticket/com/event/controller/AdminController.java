package eventticket.com.event.controller;

import eventticket.com.event.message.ReponseMessage;
import eventticket.com.event.modele.Etat;
import eventticket.com.event.modele.Role;
import eventticket.com.event.modele.User;
import eventticket.com.event.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;


    //================DEBUT DE LA METHODE PERMETTANT D'AJOUTER UN ROLE======================
    @PostMapping("/ajouterRole")
    public ReponseMessage createRole(@RequestBody Role role){

        return adminService.ajouterRole(role);
    }//================FIN DE LA METHODE PERMETTANT D'AJOUTER UN ROLE======================

    //================DEBUT DE LA METHODE PERMETTANT DE MODIFIER UN ROLE======================
    @PutMapping("/modifierRole/{idrole}")
    public ReponseMessage updateRole(@RequestBody Role role, @PathVariable Long idrole){

        return adminService.modifierRole(role, idrole);
    }//================FIN DE LA METHODE PERMETTANT DE MODIFIER UN ROLE======================

    //================DEBUT DE LA METHODE PERMETTANT D'AFFICHER LES ROLES DE LA BASE DE DONNER======================
    @GetMapping("/afficherRole")
    public List<Role> readRole(){

        return adminService.afficherRole();
    }//================FIN DE LA METHODE PERMETTANT D'AFFICHER LES ROLES DE LA BASE DE DONNER======================

    //================DEBUT DE LA METHODE PERMETTANT DE SUPPRIMER UN ROLE======================
    @DeleteMapping("/supprimerRole/{idrole}")
    public ReponseMessage deleteRole(@PathVariable Long idrole){

        return adminService.supprimerRole(idrole);
    }//================FIN DE LA METHODE PERMETTANT DE SUPPRIMER UN ROLE======================


    //================FIN DE LA GESTION DES ROLES======================


    //================DEBUT DE LA GESTION DES USERS======================


    //================DEBUT DE LA METHODE PERMETTANT D'AJOUTER UN UTILISATEUR======================
    @PostMapping("/ajouterUser")
    public ReponseMessage creerUser(@RequestBody User user){

        return adminService.ajouterUtilisateur(user);
    }//================FIN DE LA METHODE PERMETTANT D'AJOUTER UN UTILISATEUR======================


    //================DEBUT DE LA METHODE PERMETTANT DE MODIFIER UN UTILISATEUR======================
    @PutMapping("/modifierUser/{iduser}")
    public ReponseMessage updateUser(@RequestBody User user, @PathVariable Long iduser){

        return adminService.modifierUtilisateur(user, iduser);
    }//================FIN DE LA METHODE PERMETTANT DE MODIFIER UN UTILISATEUR======================

    //================DEBUT DE LA METHODE PERMETTANT DE SUPPRIMER UN UTILISATEUR======================
    @DeleteMapping("/supprimerUser/{iduser}")
    public ReponseMessage supprimerUser(@PathVariable Long iduser){

        return adminService.supprimerUtilisateur(iduser);
    }//================FIN DE LA METHODE PERMETTANT DE SUPPRIMER UN UTILISATEUR======================


    //================DEBUT DE LA METHODE PERMETTANT A UN UTILISATEUR DE SECONNECTER======================
    @GetMapping("/seconnecter/{email}/{password}")
    public Object seConnecter(@PathVariable String email, @PathVariable String password){

        return adminService.seConnecter(email, password);
    } //================FIN DE LA METHODE PERMETTANT A UN UTILISATEUR DE SECONNECTER======================


    //================DEBUT DE LA METHODE PERMETTANT D'AFFICHER LES UTILISATEURS DE LA BASE DE DONNER======================
    @GetMapping("/afficherUser")
    public List<User> afficherUser(){

        return adminService.afficherUtilisateur();
    }//================FIN DE LA METHODE PERMETTANT D'AFFICHER LES UTILISATEURS DE LA BASE DE DONNER======================


    //================DEBUT DE LA METHODE PERMETTANT D'AFFICHER LE NOMBRE  D'UTILISATEURS DE LA BASE DE DONNER======================
    @GetMapping("/afficherNbreUser")
    public int afficherNombreUser(){

        return adminService.afficherUtilisateur().size();
    }    //================FIN  DE LA METHODE PERMETTANT D'AFFICHER LE NOMBRE  D'UTILISATEURS DE LA BASE DE DONNER======================


    //================FIN DE LA GESTION DES USERS ======================


    //================DEBUT DE LA GESTION DES ETATS======================

    //================DEBUT DE LA METHODE PERMETTANT D'AJOUTER UN ETAT======================
    @PostMapping("/ajouterEtat")
    public ReponseMessage ajouterEtat(@RequestBody Etat etat) {

        return adminService.ajouterEtat(etat);
    }//================FIN DE LA METHODE PERMETTANT D'AJOUTER UN ETAT======================

    //================DEBUT DE LA METHODE PERMETTANT DE MODIFIER UN ETAT======================
    @PutMapping("/modifierEtat/{idetat}")
    public ReponseMessage modifierEtat(@RequestBody Etat etat, @PathVariable Long idetat) {

        return adminService.modifierEtat(etat, idetat);
    }//================FIN DE LA METHODE PERMETTANT DE MODIFIER UN ETAT======================

    //================DEBUT DE LA METHODE PERMETTANT DE SUPPRIMER UN ETAT======================
    @DeleteMapping("/supprimerEtat/{idetat}")
    public ReponseMessage supprimerEtat(@PathVariable Long idetat) {

        return adminService.supprimerRole(idetat);
    }//================FIN DE LA METHODE PERMETTANT DE SUPPRIMER UN ETAT======================

    //================DEBUT DE LA METHODE PERMETTANT D'AFFICHER LES ETATS ENREGISTRES======================
    @GetMapping("/afficherEtat")
    public List<Etat> afficherEtat() {
        return adminService.afficherEtat();
    }//================DEBUT DE LA METHODE PERMETTANT D'AFFICHER LES ETATS ENREGISTRES======================
}
