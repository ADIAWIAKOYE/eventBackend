package eventticket.com.event.modele;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//transforme cette classe en lieu
@Entity
//definis le nom de la table
@Table(name = "lieu")
//permet d'inclure les getter et setter
@Data
//paramettre sans arguments
@NoArgsConstructor

public class Lieu {
    @Id//permet de prendre id_lieu comme id de cette table
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    //id de la table lieu
    private long id_lieu;
    private String nom_lieu;
    private String localisation;
    private String adress;
    private int nbr_places;
}
