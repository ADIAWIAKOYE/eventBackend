package eventticket.com.event.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface Evennement_ActeurRepo {

    @Modifying
    @Transactional
    @Query(value = "insert into evennement_acteur(idevent, idacteur) values (?, ?);", nativeQuery = true)
    int INSERT_EVENNEMENT_ACTEUR(Long idevent, Long idacteur);
}
