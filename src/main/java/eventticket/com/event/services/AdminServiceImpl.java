package eventticket.com.event.services;

import eventticket.com.event.message.ReponseMessage;
import eventticket.com.event.modele.Etat;
import eventticket.com.event.modele.Role;
import eventticket.com.event.modele.User;
import eventticket.com.event.repository.EtatRepo;
import eventticket.com.event.repository.RoleRepo;
import eventticket.com.event.repository.UserRepo;
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
}
