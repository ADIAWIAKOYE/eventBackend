package eventticket.com.event.repository;

import eventticket.com.event.modele.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {

    Role findByNomrole(String nomrole);

    Role findByIdrole(Long idrole);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Role (nomrole) VALUES (\"admin\");",nativeQuery = true)
    void creationrole();
}
