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
    private Long idlieu;
    private String nom;
    private String localisation;
    private String adress;
    private int nbrPlaces;
}
