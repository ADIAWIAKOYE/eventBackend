package eventticket.com.event.modele;

import lombok.Data;
import org.apache.naming.java.javaURLContextFactory;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.Timer;

//transforme cette classe en table
@Entity
//definis le nom de la table
@Table(name = "evennement")
//permet d'inclur les getter
@Data
//paramettre sans argument
public class Evennement {

    @Id//permet de prendre id_evennement comme id de cette table
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id_evennement;
    private String nom_evennement;
    private String desciption_evennement;
    private Date date_start;
    private LocalTime time_start;
    private Date date_end;
    private LocalTime time_end;
    private String affiche;
    private int nbre_ticket_dispo;
    private Boolean ticket_dispo;
    private String categorie_evennement;
}
