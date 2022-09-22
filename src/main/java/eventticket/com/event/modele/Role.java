package eventticket.com.event.modele;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//transforme cette cette classe en table
@Entity
//definis le nom de la table
@Table(name = "role")
//permet d'inclure les getter et setter
@Data
//paramettre sans arguments
@NoArgsConstructor
public class Role {
    @Id//permet de prendre id_etat comme id de cette table
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    //id de la etat
    private long id_role;
    private String nom_role;
}
