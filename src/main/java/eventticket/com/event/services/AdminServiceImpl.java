package eventticket.com.event.services;

import eventticket.com.event.message.ReponseMessage;
import eventticket.com.event.modele.*;
import eventticket.com.event.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private EtatRepo etatRepo;

    @Autowired
    private ActeurRepo acteurRepo;

    @Autowired
    private LieuRepo lieuRepo;

    //================DEBUT DE LA METHODE PERMETTANT D'AJOUTER UN ROLE======================
    @Override
    public ReponseMessage ajouterRole(Role role) {
        if (roleRepo.findByNomrole(role.getNomrole()) == null){
            roleRepo.save(role);

            ReponseMessage message = new ReponseMessage("Rôle ajouté avec succes", true);
            return  message;
        }else {
            ReponseMessage message = new ReponseMessage("Cet rôle existe déjà ", false);

            return message;
        }
    }

    //================DEBUT DE LA METHODE PERMETTANT DE MODIFIER UN ROLE======================
    @Override
    public ReponseMessage modifierRole(Role role, Long idrole) {
        if (roleRepo.findByIdrole(idrole) != null){
        Role updateRole = roleRepo.findById(idrole).get();
        updateRole.setNomrole(role.getNomrole());
        roleRepo.saveAndFlush(updateRole);

            ReponseMessage message = new ReponseMessage("Rôle modifier avec succes", true);
            return  message;
        }else {
            ReponseMessage message = new ReponseMessage("Cet rôle n'existe pas ", false);

            return message;
        }
    }

    //================DEBUT DE LA METHODE PERMETTANT D'AFFICHER LES ROLES DE LA BASE DE DONNER===================
    @Override
    public List<Role> afficherRole() {

        return roleRepo.findAll();
    }

    //================DEBUT DE LA METHODE PERMETTANT DE SUPPRIMER UN ROLE======================
    @Override
    public ReponseMessage supprimerRole(Long idrole) {
        if (roleRepo.findByIdrole(idrole) != null){
            roleRepo.deleteById(idrole);

            ReponseMessage message = new ReponseMessage("Rôle Supprimer avec succes", true);
            return  message;
        }else {
            ReponseMessage message = new ReponseMessage("Cet rôle n'existe pas ", false);

            return message;
        }
    }

    @Override
    public Role trouverRoleParId(Long idrole) {

        return roleRepo.findByIdrole(idrole);
    }

    //================FIN DE LA GESTION DES ROLES======================


    //================DEBUT DE LA GESTION DES USERS======================


    //================DEBUT DE LA METHODE PERMETTANT D'AJOUTER UN USER======================
    @Override
    public ReponseMessage ajouterUtilisateurU(User user, String nomrole) {
        if (userRepo.findByEmail(user.getEmail()) == null){
            Role role = new Role();

            if (roleRepo.findByNomrole(nomrole) == null){

                ReponseMessage message = new ReponseMessage("Cet role n'existe pas  ", false);

                return message;

            }else {
                role=roleRepo.findByNomrole(nomrole);
                user.setRole(role);
                userRepo.save(user);
            }

            ReponseMessage message = new ReponseMessage("utilisateur ajouté avec succes", true);
            return  message;
        }else {
            ReponseMessage message = new ReponseMessage("Cet utilisateur existe déjà ", false);

            return message;
        }
    }//================FIN DE LA METHODE PERMETTANT D'AJOUTER UN USER======================



    //================DEBUT DE LA METHODE PERMETTANT DE MODIFIER UN USER======================
    @Override
    public ReponseMessage modifierUtilisateur(User user, Long iduser) {
        if (userRepo.findByIduser(iduser) != null){
            User updateUser = userRepo.findById(iduser).get();
            updateUser.setNom(user.getNom());
            updateUser.setPrenom(user.getPrenom());
            updateUser.setEmail(user.getEmail());
            updateUser.setProfile(user.getProfile());
            updateUser.setPseudo(user.getPseudo());
            updateUser.setNumero(user.getNumero());
            updateUser.setRole(user.getRole());
            userRepo.saveAndFlush(updateUser);

            ReponseMessage message = new ReponseMessage("User modifier avec succes", true);
            return  message;
        }else {
            ReponseMessage message = new ReponseMessage("Cet user n'existe pas ", false);

            return message;
        }
    } //================FIN DE LA METHODE PERMETTANT DE MODIFIER UN USER======================

    //================DEBUT DE LA METHODE PERMETTANT D'AFFICHER LES USERS DE LA BASE DE DONNER======================
    @Override
    public List<User> afficherUtilisateur() {

        return userRepo.findAll();
    }//================FIN DE LA METHODE PERMETTANT D'AFFICHER LES USERS DE LA BASE DE DONNER======================

    //================DEBUT DE LA METHODE PERMETTANT DE SUPPRIMER UN USER======================
    @Override
    public ReponseMessage supprimerUtilisateur(Long iduser) {
        if (userRepo.findByIduser(iduser) != null){
            userRepo.deleteById(iduser);

            ReponseMessage message = new ReponseMessage("utilisateur Supprimer avec succes", true);
            return  message;
        }else {
            ReponseMessage message = new ReponseMessage("Cet utilisateur n'existe pas ", false);

            return message;
        }
    }//================FIN DE LA METHODE PERMETTANT DE SUPPRIMER UN USER======================

    //================DEBUT DE LA METHODE PERMETTANT A UN USER DE SE CONNECTER======================
    @Override
    public Object seConnecter(String email, String password) {

        User user = userRepo.findByEmailAndPassword(email, password);
        if (user != null){
            return user;
        } else {

            ReponseMessage message = new ReponseMessage("Mot de passe ou identifiant incorrect", false);

            return message;
        }

    }//================FIN DE LA METHODE PERMETTANT A UN USER DE SE CONNECTER======================

    //================DEBUT DE LA METHODE PERMETTANT DE RETROUVER UN USER PAR SON ID======================
    @Override
    public User trouverUtilisateurParId(Long id) {

        return userRepo.findByIduser(id);
    }//================FIN DE LA METHODE PERMETTANT DE RETROUVER UN USER PAR SON ID======================


    //================FIN DE LA GESTION DES USERS======================

    //================DEBUT DE LA GESTION DES ETATS======================


    //================DEBUT DE LA METHODE PERMETTANT D'AJOUTER UN ETAT======================
    @Override
    public ReponseMessage ajouterEtat(Etat etat) {
        if (etatRepo.findByContenu(etat.getContenu()) == null){
            etatRepo.save(etat);

            ReponseMessage message = new ReponseMessage("etat ajouté avec succes", true);
            return  message;
        }else {
            ReponseMessage message = new ReponseMessage("Cet etat existe déjà ", false);

            return message;
        }
    } //================FIN DE LA METHODE PERMETTANT D'AJOUTER UN ETAT======================

    //================DEBUT DE LA METHODE PERMETTANT DE MODIFIER UN ETAT======================
    @Override
    public ReponseMessage modifierEtat(Etat etat, Long idetat) {
        if (etatRepo.findByIdetat(idetat) != null){
            Etat updateEtat = etatRepo.findById(idetat).get();
            updateEtat.setContenu(etat.getContenu());
            etatRepo.saveAndFlush(updateEtat);

            ReponseMessage message = new ReponseMessage("Etat modifier avec succes", true);
            return  message;
        }else {
            ReponseMessage message = new ReponseMessage("Cet etat n'existe pas ", false);

            return message;
        }
    }//================FIN DE LA METHODE PERMETTANT DE MODIFIER UN ETAT======================

    //================DEBUT DE LA METHODE PERMETTANT DE SUPPRIMER UN ETAT======================
    @Override
    public ReponseMessage supprimerEtat(Long idetat) {
        if (etatRepo.findByIdetat(idetat) != null){
            etatRepo.deleteById(idetat);

            ReponseMessage message = new ReponseMessage("etat Supprimer avec succes", true);
            return  message;
        }else {
            ReponseMessage message = new ReponseMessage("Cet etat n'existe pas ", false);

            return message;
        }
    }//================FIN DE LA METHODE PERMETTANT DE SUPPRIMER UN ETAT======================

    //================DEBUT DE LA METHODE PERMETTANT D'AFFICHER LES ETATS DE LA BASE DE DONNER======================
    @Override
    public List<Etat> afficherEtat() {

        return etatRepo.findAll();
    } //================FIN DE LA METHODE PERMETTANT D'AFFICHER LES ETATS DE LA BASE DE DONNER======================

    //================DEBUT DE LA METHODE PERMETTANT DE RETROUVER UN ETAT PAR SON ID ======================
    @Override
    public Etat trouverEtatParId(Long idetat) {

        return etatRepo.findByIdetat(idetat);
    } //================FIN DE LA METHODE PERMETTANT DE RETROUVER UN ETAT PAR SON ID ======================

    //================DEBUT DE LA METHODE PERMETTANT DE RETROUVER UN ETAT PAR SON CONTENU ======================
    @Override
    public Etat trouverEtatParContenu(String contenu) {

        return etatRepo.findByContenu(contenu);
    }//================FIN DE LA METHODE PERMETTANT DE RETROUVER UN ETAT PAR SON CONTENU ======================


    //================FIN DE LA GESTION DES ETATS======================

    //================DEBUT DE LA GESTION DES ACTEURS======================


    //================DEBUT DE LA METHODE PERMETTANT D'AJOUTER UN ACTEUR======================
    @Override
    public ReponseMessage ajouterActeur(Acteur acteur) {
        if (acteurRepo.findByNom(acteur.getNom()) == null){
            acteurRepo.save(acteur);

            ReponseMessage message = new ReponseMessage("Acteur ajouté avec succes", true);
            return  message;
        }else {
            ReponseMessage message = new ReponseMessage("Cet Acteur existe déjà ", false);

            return message;
        }
    }//================FIN DE LA METHODE PERMETTANT D'AJOUTER UN ACTEUR======================

    //================DEBUT DE LA METHODE PERMETTANT DE MODIFIER UN ACTEUR======================
    @Override
    public ReponseMessage modifierActeur(Acteur acteur, Long idacteur) {
        if (acteurRepo.findByIdacteur(idacteur) != null){
            Acteur updateActeur = acteurRepo.findById(idacteur).get();
            updateActeur.setNom(acteur.getNom());
           // updateActeur.setEvennements(acteur.getEvennements());
            acteurRepo.saveAndFlush(updateActeur);

            ReponseMessage message = new ReponseMessage("Acteur modifier avec succes", true);
            return  message;
        }else {
            ReponseMessage message = new ReponseMessage("Cet acteur n'existe pas ", false);

            return message;
        }
    } //================FIN DE LA METHODE PERMETTANT DE MODIFIER UN ACTEUR======================


    //================DEBUT DE LA METHODE PERMETTANT DE SUPPRIMER UN ACTEUR======================
    @Override
    public ReponseMessage supprimerActeur(Long id) {
        if (acteurRepo.findByIdacteur(id) != null){
            acteurRepo.deleteById(id);

            ReponseMessage message = new ReponseMessage("Acteur Supprimer avec succes", true);
            return  message;
        }else {
            ReponseMessage message = new ReponseMessage("Cet acteur n'existe pas ", false);

            return message;
        }
    }//================FIN DE LA METHODE PERMETTANT DE SUPPRIMER UN ACTEUR======================

    //================DEBUT DE LA METHODE PERMETTANT D'AFFICHER LES ACTEURS DE LA BASE DE DONNE======================
    @Override
    public List<Acteur> afficherActeur() {

        return acteurRepo.findAll();
    }//================FIN DE LA METHODE PERMETTANT D'AFFICHER LES ACTEURS DE LA BASE DE DONNE======================

    //================DEBUT DE LA METHODE PERMETTANT DE RETROUVER UN ACTEUR PAR SON ID======================
    @Override
    public Acteur trouverActeurParid(Long idacteur) {

        return acteurRepo.findByIdacteur(idacteur);
    }//================FIN DE LA METHODE PERMETTANT DE RETROUVER UN ACTEUR PAR SON ID======================

    //================DEBUT DE LA METHODE PERMETTANT DE RETROUVER UN ACTEUR PAR SON NOM======================
    @Override
    public Acteur trouverActeurParNom(String nom) {

        return acteurRepo.findByNom(nom);
    }//================FIN DE LA METHODE PERMETTANT DE RETROUVER UN ACTEUR PAR SON NOM======================


    //================FIN DE LA GESTION DES ACTEURS======================

    //================DEBUT DE LA GESTION DES LIEUS======================


    //================DEBUT DE LA METHODE PERMETTANT D'AJOUTER UN LIEU======================
    @Override
    public ReponseMessage ajouterLieu(Lieu lieu) {
        if (lieuRepo.findByNom(lieu.getNom()) == null){
            lieuRepo.save(lieu);

            ReponseMessage message = new ReponseMessage("Lieu ajouté avec succes", true);
            return  message;
        }else {
            ReponseMessage message = new ReponseMessage("Cet lieu existe déjà ", false);

            return message;
        }
    } //================FIN DE LA METHODE PERMETTANT D'AJOUTER UN LIEU======================

    //================DEBUT DE LA METHODE PERMETTANT DE MODIFIER UN LIEU======================
    @Override
    public ReponseMessage modifierLieu(Lieu lieu, Long idlieu) {
        if (lieuRepo.findByIdlieu(idlieu) != null){
            Lieu updateLieu = lieuRepo.findById(idlieu).get();
            updateLieu.setNom(lieu.getNom());
            updateLieu.setAdress(lieu.getAdress());
            updateLieu.setNbrPlaces(lieu.getNbrPlaces());
            updateLieu.setLocalisation(lieu.getLocalisation());
            lieuRepo.saveAndFlush(updateLieu);

            ReponseMessage message = new ReponseMessage("Lieu modifier avec succes", true);
            return  message;
        }else {
            ReponseMessage message = new ReponseMessage("Cet lieu n'existe pas ", false);

            return message;
        }
    }//================FIN DE LA METHODE PERMETTANT DE MODIFIER UN LIEU======================

    //================DEBUT DE LA METHODE PERMETTANT DE SUPPRIMER UN LIEU======================
    @Override
    public ReponseMessage supprimerLieu(Long id) {
        if (lieuRepo.findByIdlieu(id) != null){
            lieuRepo.deleteById(id);

            ReponseMessage message = new ReponseMessage("Lieu Supprimer avec succes", true);
            return  message;
        }else {
            ReponseMessage message = new ReponseMessage("Cet lieu n'existe pas ", false);

            return message;
        }
    }//================FIN DE LA METHODE PERMETTANT DE SUPPRIMER UN LIEU======================

    //================DEBUT DE LA METHODE PERMETTANT D'AFFICHER LES LIEUS DE LA BASE DE DONNER=========================
    @Override
    public List<Lieu> afficherLieu() {

        return lieuRepo.findAll();
    }//================FIN DE LA METHODE PERMETTANT D'AFFICHER LES LIEUS DE LA BASE DE DONNER=========================

    //================DEBUT DE LA METHODE PERMETTANT DE RETROUVER UN LIEU PAR SON ID=========================
    @Override
    public Lieu trouverLieuParid(Long idlieu) {

        return lieuRepo.findByIdlieu(idlieu);
    }//================FIN DE LA METHODE PERMETTANT DE RETROUVER UN LIEU PAR SON ID=========================

    //================DEBUT DE LA METHODE PERMETTANT DE RETROUVER UN LIEU PAR SON NOM=========================
    @Override
    public Lieu trouverLieuParNom(String nom) {

        return lieuRepo.findByNom(nom);
    }//================FIN DE LA METHODE PERMETTANT DE RETROUVER UN LIEU PAR SON NOM=========================
}
