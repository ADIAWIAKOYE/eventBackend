package eventticket.com.event.modele;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//transforme cette classe en table
@Entity
//definis le nom de la table
@Table(name = "clientvenu")
//premet d'inclure les getter et setter
@Data
//paramettre sans arguments
@NoArgsConstructor
public class ClientVenu {
    @Id//permet de prendre id_clientvenu comme id de cette table
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //id de la table clientvenu
    private Long idclientvenu;

    //relation entre la table postulant trié et tirage
    /* @ManyToOne
    @JoinColumn(name = "id_evennement")
    private Evennement id_evennement;

*/
}

