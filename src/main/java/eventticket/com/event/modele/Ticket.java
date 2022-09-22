package eventticket.com.event.modele;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

//transforme cette classe en table
@Entity
//definis le nom de la table
@Table(name = "ticket")
//permet d'inclure les getter et setter
@Data
//paramettre sans arguments
@NoArgsConstructor
public class Ticket {

    @Id//permet de prendre id_ticket comme id de cette table
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    //id de la table ticket
    private long id_ticket;
    private String num_serie;
    private Date date_achat;
}
