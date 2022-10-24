package eventticket.com.event.modele;

import lombok.Data;

import javax.persistence.*;

//transforme cette classe en table
@Entity
//definis le nom de la table
@Table
//permet d'inclur les getter
@Data
//paramettre sans argument
public class Evennement_Acteur {

    @Id//permet de prendre id_evennement comme id de cette table
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @ManyToOne
    @JoinColumn(name = "idevent")
    private Evennement evennement;

    @ManyToOne
    @JoinColumn(name = "idacteur")
    private Acteur acteur;
}
