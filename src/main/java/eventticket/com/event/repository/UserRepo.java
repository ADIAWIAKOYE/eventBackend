package eventticket.com.event.repository;

import eventticket.com.event.modele.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface UserRepo extends JpaRepository<User, Long> {

    User findByEmailAndPassword(String email, String password);

    User findByEmail(String email);

    User findByIduser(Long iduser);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO user (nom, prenom, email, numero, pseudo, profile, password, role_idrole)  VALUES(\"ADIAWIAKOYE\", \"Ahmadou\", \"adiawiakoye.le10@gmail.com\",  \"676665554\",  \"Diadie\",  \"monProfile.png\",  \"mot de passe\", 1);",nativeQuery = true)
    void creationadmin();
}
