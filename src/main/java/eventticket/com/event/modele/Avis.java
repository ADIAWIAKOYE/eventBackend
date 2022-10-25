package eventticket.com.event.modele;

import lombok.*;

import javax.persistence.*;

//transforme cette classe en table
@Entity
//definis le nom de la table
@Table(name = "avis")
//permet d'inclure les getter et setter
@Getter
@Setter
@AllArgsConstructor
//paramettre sans arguments
@NoArgsConstructor
public class Avis {

    @Id//permet de prendre id_avis commeid de cette table
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    //id de l'AVIS
    private Long idavis;
    private String Contenu;
}
