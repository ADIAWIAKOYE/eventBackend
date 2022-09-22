package eventticket.com.event.modele;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//transforme cette classe en table
@Entity
//definis le nom de la table
@Table(name = "user")
//permet d'inclure les getter et setter
@Data
//paramettre sans arguments
@NoArgsConstructor
public class User {

    @Id//permet de prendre id_user comme id de cette table
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //id de la table User
    private long id_user;
    private String nom_user;
    private String prenom_user;
    private String email_user;
    private String pseudo_user;
    private String profile_user;
    private String password_user;
    private String repassword_user;
}
