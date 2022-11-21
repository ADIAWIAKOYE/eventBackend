package eventticket.com.event.services;

import eventticket.com.event.message.ReponseMessage;
import eventticket.com.event.modele.*;
import eventticket.com.event.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class OrganisateurServiceImpl implements OrganisateurService{

    @Autowired
    private EvennementRepo evennementRepo;

    @Autowired
    private LieuRepo lieuRepo;

    @Autowired
    private ActeurRepo acteurRepo;

    @Autowired
    private CategorieTicketRepo categorieTicketRepo;

   /* @Autowired
    final private AdminService adminService;
*/
    @Autowired
    private Evennement_ActeurRepo evennementActeurRepo;

    //================DEBUT DE LA METHODE PERMETTANT D'AJOUTER UN EVENNEMENT======================
    @Override
    public ReponseMessage ajouterEvent(Evennement evennement, String idacteur, String nomlieu) {

        List<Evennement> eventnom = evennementRepo.findByNomevent(evennement.getNomevent());

        for (Evennement nomevent : eventnom) {

            System.out.println("le nom de l'evennement est "+nomevent.getDateStart());
            System.out.println("le nom1 de l'evennement est "+evennement.getDateStart());

            if (nomevent.getDateStart().equals(evennement.getDateStart()) ) {

                ReponseMessage message = new ReponseMessage("Cet evennement existe déjà ", false);
                return message;
            }
        }
                evennement.setTicketDispo(false);

                if (lieuRepo.findByNomlieu(nomlieu) == null) {
                    ReponseMessage message = new ReponseMessage("Cet lieu n'existe pas  ", false);
                    return message;
                } else {
                    Lieu lieu = lieuRepo.findByNomlieu(nomlieu);
                    evennement.setLieu(lieu);

                    String[] acteurTab = idacteur.split(",");
                    for (String te : acteurTab) {
                        long l = Long.parseLong(te);

                        Acteur acteur = acteurRepo.findByIdacteur(l);
                        if (acteur == null) {
                            ReponseMessage message = new ReponseMessage("Un des acteur n'existe pas", true);
                            return message;
                        }
                        evennement.getActeurs().add(acteur);
                    }
                    Etat etat = new Etat();

                    etat.setIdetat(1l);

                    evennement.setEtat(etat);

                    evennementRepo.save(evennement);
                }
                ReponseMessage message = new ReponseMessage("Evennement ajouter avec succes", true);
                return message;
            } //================FIN DE LA METHODE PERMETTANT D'AJOUTER UN EVENNEMENT======================

      //================DEBUT DE LA METHODE PERMETTANT DE MODIFIER UN EVENNEMENT======================
    @Override
    public ReponseMessage modifierEvent(Evennement evennement, Long idevent) {
            if (evennementRepo.findByIdevent(idevent) != null){

                Evennement updateEvent = evennementRepo.findById(idevent).get();
                updateEvent.setNomevent(evennement.getNomevent());
                updateEvent.setDesciption(evennement.getDesciption());
                updateEvent.setDateStart(evennement.getDateStart());
                updateEvent.setDateEnd(evennement.getDateEnd());
                updateEvent.setTimeStart(evennement.getTimeStart());
                updateEvent.setTimeEnd(evennement.getTimeEnd());
                updateEvent.setNbreTicketDispo(evennement.getNbreTicketDispo());
                updateEvent.setCategorie(evennement.getCategorie());
                updateEvent.setLieu(evennement.getLieu());

                evennementRepo.saveAndFlush(updateEvent);
                ReponseMessage message = new ReponseMessage("Evennement modifier avec succes", true);
                return  message;
            }else {
                ReponseMessage message = new ReponseMessage("Cet evennement n'existe pas ", false);

                return message;
            }
    }  //================FIN DE LA METHODE PERMETTANT DE MODIFIER UN EVENNEMENT======================

    //================DEBUT DE LA METHODE PERMETTANT DE SUPPRIMER UN EVENNEMENT======================
    @Override
    public ReponseMessage supprimerEvent(Long idevent) {
        if (evennementRepo.findByIdevent(idevent) != null){
            evennementRepo.deleteById(idevent);

            ReponseMessage message = new ReponseMessage("Evennement Supprimer avec succes", true);
            return  message;
        }else {
            ReponseMessage message = new ReponseMessage("Cet evennement n'existe pas ", false);

            return message;
        }
    }//================FIN DE LA METHODE PERMETTANT DE SUPPRIMER UN EVENNEMENT======================

    //================DEBUT DE LA METHODE PERMETTANT D'AFFICHER LES EVENNEMENTS DE LA BASE DE DONNER======================
    @Override
    public List<Evennement> afficherEvent() {

        return evennementRepo.findAll();
    } //================FIN DE LA METHODE PERMETTANT D'AFFICHER LES EVENNEMENTS DE LA BASE DE DONNER======================

    //================DEBUT DE LA METHODE PERMETTANT DE RETROUVER UN EVENNEMENT PAR SON ID======================
    @Override
    public Evennement trouverEventParId(Long idevent) {

        return evennementRepo.findByIdevent(idevent);
    }//================FIN DE LA METHODE PERMETTANT DE RETROUVER UN EVENNEMENT PAR SON ID======================

    //================DEBUT DE LA METHODE PERMETTANT DE RETROUVER UN EVENNEMENT PAR SON NOM======================
    @Override
     public List<Evennement>trouverEventParNom(String nomevent) {

        return evennementRepo.findByNomevent(nomevent);
    } //================FIN DE LA METHODE PERMETTANT DE RETROUVER UN EVENNEMENT PAR SON NOM======================

    @Override
    public Evennement trouverEventParNomDateStart(String nomevent, Date dateStart) {
        return evennementRepo.findByNomeventAndDateStart(nomevent, dateStart);
    }

    @Override
    public Evennement truverEventParDateStart(LocalDate dateStart) {

        return evennementRepo.findByDateStart(dateStart);
    }//================FIN DE LA METHODE PERMETTANT DE RETROUVER UN EVENNEMENT PAR SA DATE DATE DE DEBUT======================


    //================FIN DE LA GESTION DES EVENNEMENT======================

    //================DEBUT DE LA GESTION DES CATEGORIES DE TICKET======================


    //================DEBUT DE LA METHODE PERMETTANT D'AJOUTER UNE CATEGORIE DE TICKET======================

    @Override
    public ReponseMessage ajouterCategorieTicket(CategorieTicket categorieTicket, Long idevent) {
        List<CategorieTicket> catTicket = categorieTicketRepo.findByDescription(categorieTicket.getDescription());
        Evennement event = evennementRepo.findByIdevent(idevent);
         categorieTicket.setEvennement(event);
        for (CategorieTicket cateTicket : catTicket){
            if (cateTicket.getEvennement() == categorieTicket.getEvennement()){
                ReponseMessage message = new ReponseMessage("Cet categorie existe déjà pour cet evennement ", false);
                return message;
            }
        }
        if (evennementRepo.findByIdevent(idevent) == null) {
            ReponseMessage message = new ReponseMessage("Cet evennement n'existe pas  ", false);
            return message;
        }
        else {
            Evennement evente = evennementRepo.findByIdevent(idevent);
            categorieTicket.setEvennement(evente);
            categorieTicketRepo.save(categorieTicket);
        }
        ReponseMessage message = new ReponseMessage("categorie ajouter avec succes", true);
        return message;
    }//================FIN DE LA METHODE PERMETTANT D'AJOUTER UNE CATEGORIE DE TICKET======================


     //================DEBUT DE LA METHODE PERMETTANT DE MODIFIER  UNE CATEGORIE DE TICKET======================
    @Override
    public ReponseMessage modifierCategorieTicket(CategorieTicket categorieTicket, Long idcategorie) {
        if (categorieTicketRepo.findByIdcategorie(idcategorie) != null){
            CategorieTicket updateCategorieTicket = categorieTicketRepo.findById(idcategorie).get();

            updateCategorieTicket.setDescription(categorieTicket.getDescription());
            updateCategorieTicket.setPrixcat(categorieTicket.getPrixcat());
            updateCategorieTicket.setNbrticket(categorieTicket.getNbrticket());
            updateCategorieTicket.setEvennement(categorieTicket.getEvennement());

            categorieTicketRepo.saveAndFlush(updateCategorieTicket);
            ReponseMessage message = new ReponseMessage("Categorie modifier avec succes", true);
            return  message;
        }else {
            ReponseMessage message = new ReponseMessage("Cet Categorie n'existe pas ", false);

            return message;
        }
    }//================FIN DE LA METHODE PERMETTANT DE MODIFIER  UNE CATEGORIE DE TICKET======================


    //================DEBUT DE LA METHODE PERMETTANT DE SUPPRIMER UNE CATEGORIE DE TICKET======================
    @Override
    public ReponseMessage supprimerCategorieTicket(Long idcategorie) {
        if (categorieTicketRepo.findByIdcategorie(idcategorie) != null){
            categorieTicketRepo.deleteById(idcategorie);

            ReponseMessage message = new ReponseMessage("Categorie supprimer avec succes", true);
            return  message;
        }else {
            ReponseMessage message = new ReponseMessage("Cet Categorie n'existe pas ", false);

            return message;
        }
    }//================FIN DE LA METHODE PERMETTANT DE SUPPRIMER UNE CATEGORIE DE TICKET======================


    //================DEBUT DE LA METHODE PERMETTANT D'AFFICHER LES CATEGORIES DE TICKET======================
    @Override
    public List<CategorieTicket> afficherCategorieTicket() {

        return categorieTicketRepo.findAll();
    } //================FIN DE LA METHODE PERMETTANT D'AFFICHER LES CATEGORIES DE TICKET======================

    @Override
    public CategorieTicket trouverCategorieTicketParid(Long idcategorie) {

        return categorieTicketRepo.findByIdcategorie(idcategorie);
    }

    @Override
    public List <CategorieTicket> trouverCategorieTicketParNom(String categorie) {

        return categorieTicketRepo.findByDescription(categorie);
    }
}
