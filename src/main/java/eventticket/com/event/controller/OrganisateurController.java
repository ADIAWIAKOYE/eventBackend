package eventticket.com.event.controller;

import eventticket.com.event.services.OrganisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/organisateur")
public class OrganisateurController {

    @Autowired
    private OrganisateurService organisateurService;



}
