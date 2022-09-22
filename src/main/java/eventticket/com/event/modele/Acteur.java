package eventticket.com.event.modele;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//transforme cette classe en table
@Entity
//definir le nom de la table
@Table(name = "acteur")
//permet d'inclure les getter et setter
@Data
//paramettre sans arguments
@NoArgsConstructor

public class Acteur {

    @Id//permet de prendre id_acteur comme id de cette table
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    //id de l'Acteur
    private long id_acteur;
    private String nom_acteur;
}
