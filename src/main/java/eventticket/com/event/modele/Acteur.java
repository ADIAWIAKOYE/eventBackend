package eventticket.com.event.modele;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//transforme cette classe en table
@Entity
//definir le nom de la table
@Table(name = "acteur")
//permet d'inclure les getter et setter
//@Data
@Getter
@Setter
@AllArgsConstructor
//paramettre sans arguments
@NoArgsConstructor

public class Acteur {

    @Id//permet de prendre id_acteur comme id de cette table
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    //id de l'Acteur
    private Long idacteur;
    private String nomacteur;


    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })

    @JoinTable(
            name="Evennement_Acteur",
            joinColumns = @JoinColumn(name = "idacteur"),
            inverseJoinColumns = @JoinColumn(name = "idevent")
    )

    private List<Evennement> evennements = new ArrayList<>();
}
