package ru.src.web.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.src.web.model.Client;
import ru.src.web.repositories.ClientRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Client> getAllClient() {
        return clientRepository.findAllByState(Client.State.CONFIRMED);
    }

    @Override
    public List<Client> getAllClientByLogin(String login) {
        return clientRepository.getAllByLogin(login);
    }


    @Override
    public String findClient(long id) {
        Optional<Client> clientOptional = clientRepository.findById(id);
        return String.valueOf(clientOptional.get().getRole());
    }

    @Override
    public void deleteClient(long id) {
        Optional<Client> clientOptional = clientRepository.findById(id);
        if (!clientOptional.isPresent()) {
            throw new UsernameNotFoundException("Аккаунт не найдет");
        }
        Client client = clientOptional.get();
        client.setState(Client.State.DELETED);
        clientRepository.save(client);
    }
    @Override
    public List<Client> getClientId(long id) {
        Optional <Client> client = clientRepository.findById(id);
        List<Client> rest = new ArrayList<>();
        client.ifPresent(rest::add);
        return rest;
    }
    @Override
    public void updateClientRole(long id) {
        Client client = clientRepository.findById(id).orElseThrow();
        String role = String.valueOf(client.getRole());
       if (role.equals("ADMIN")) {
           client.setRole(Client.Role.USER);
       }
       if (role.equals("USER")){
           client.setRole(Client.Role.ADMIN);
       }
        clientRepository.save(client);

        System.out.println("Роль обнавлена");
    }

    @Override
    public Client findClientId(long id) {
        return clientRepository.findId(id);
    }

}
