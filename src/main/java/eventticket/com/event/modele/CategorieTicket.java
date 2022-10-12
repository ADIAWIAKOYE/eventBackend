package eventticket.com.event.modele;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//transforme cette classe en table
@Entity
//definis le nom de la table
@Table(name = "categorieticket")
//permet d'inclure les getter et setter
@Data
//paramettre sans arguments
@NoArgsConstructor

public class CategorieTicket {

    @Id//permet de prendre id_categorieticket comme id de cette table
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    //id de la table CategorieTicket
    private Long idcategorie;
    private String description;
    private int prixcat;
    private int nbrticket;
}
