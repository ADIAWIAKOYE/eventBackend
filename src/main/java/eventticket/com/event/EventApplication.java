package eventticket.com.event;

import eventticket.com.event.modele.Role;
import eventticket.com.event.repository.EtatRepo;
import eventticket.com.event.repository.RoleRepo;
import eventticket.com.event.repository.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EventApplication implements CommandLineRunner {

    private final RoleRepo roleRepo;
    private final UserRepo userRepo;
    private final EtatRepo etatRepo;

    public EventApplication(RoleRepo roleRepo, UserRepo userRepo, EtatRepo etatRepo){

        this.roleRepo = roleRepo;
        this.userRepo = userRepo;
        this.etatRepo = etatRepo;
    }

    public static void main(String[] args) {

        SpringApplication.run(EventApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
      if (userRepo.findAll().size() == 0){
          roleRepo.creationrole();
          userRepo.creationadmin();
          etatRepo.creationetat();
      }
    }
}
