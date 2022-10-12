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

    private Long idevent;
    private String nom;
    private String desciption;
    private Date dateStart;
    private LocalTime timeStart;
    private Date dateEnd;
    private LocalTime timeEnd;
    private String affiche;
    private int nbreTicketDispo;
    private Boolean ticketDispo;
    private String categorie;
}
