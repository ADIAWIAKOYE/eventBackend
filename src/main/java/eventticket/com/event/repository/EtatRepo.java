package eventticket.com.event.repository;

import eventticket.com.event.modele.Etat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface EtatRepo extends JpaRepository<Etat, Long> {

    Etat findByContenu(String contenu);

    Etat findByIdetat(Long idetat);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO etat (contenu)  VALUES(\"A Vénir\");",nativeQuery = true)
    void creationetat();
}
