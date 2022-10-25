package eventticket.com.event.modele;

import lombok.*;

import javax.persistence.*;

//transforme cette classe en table
@Entity
//definis le nom de la table
@Table(name = "user")
//permet d'inclure les getter et setter
@Getter
@Setter
@AllArgsConstructor
//paramettre sans arguments
@NoArgsConstructor
public class User {

    @Id//permet de prendre id_user comme id de cette table
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //id de la table User
    private Long iduser;
    private String nom;
    private String prenom;
    private String email;
    private String pseudo;
    private String numero;
    private String profile;
    private String password;

    @ManyToOne
    private Role role;
}


