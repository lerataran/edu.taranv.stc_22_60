package ru.src.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.src.web.dto.ClientDto;
import ru.src.web.model.Client;
import ru.src.web.service.ClientService;

import java.util.List;
@Controller
@RequestMapping("/clients")
public class ClientController {
    private final ClientService clientService;
    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public String getAllClients(Model model) {
        List<Client> clients = clientService.getAllClient();
        model.addAttribute("clients", clients);
        return "clients";
    }
    @PostMapping("/{id}/delete")
    public String deleteClient(@PathVariable("id") Long id) {
       clientService.deleteClient(id);
       return "redirect:/clients";
    }
    @GetMapping("/{id}/edit")
    public String getClientEdit(@PathVariable (value = "id") long id, Model model) {
        List<Client> clients = clientService.getClientId(id);
        model.addAttribute("client", clients);
        return "clientEdit";
    }
    @PostMapping("/{id}/edit")
    public String clientEdit(@PathVariable (value = "id") long id) {
        clientService.updateClientRole(id);
        return "redirect:/clients";
    }
}
