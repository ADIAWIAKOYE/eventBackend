package eventticket.com.event.modele;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

//transforme cette classe en table
@Entity
//definis le nom de la table
@Table(name = "ticket")
//permet d'inclure les getter et setter
@Getter
@Setter
@AllArgsConstructor
//paramettre sans arguments
@NoArgsConstructor
public class Ticket {

    @Id//permet de prendre id_ticket comme id de cette table
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    //id de la table ticket
    private Long idticket;
    private String numserie;
    private Date dateachat;

    
}
