package ru.src.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.src.web.model.Client;
import ru.src.web.service.ClientService;

import java.util.List;

@Controller
@RequestMapping("/profile")
public class ProfileController {
    private final ClientService clientService;
    @Autowired
    public ProfileController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public String getProfilePage(Authentication authentication, Model model) {
        List<Client> clients = clientService.getAllClientByLogin(authentication.getName());
        model.addAttribute("client", clients);
        return "profile";
    }
}

