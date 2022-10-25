package eventticket.com.event.modele;

import lombok.*;

import javax.persistence.*;

//transforme cette cette classe en table
@Entity
//definis le nom de la table
@Table(name = "role")
//permet d'inclure les getter et setter
@Getter
@Setter
@AllArgsConstructor
//paramettre sans arguments
@NoArgsConstructor
public class Role {
    @Id//permet de prendre id_etat comme id de cette table
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    //id de la etat
    private Long idrole;
    private String nomrole;
}
