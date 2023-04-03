package ru.src.web.service;


import ru.src.web.model.Client;

import java.util.List;

public interface ClientService {
    List<Client> getAllClient();
    List<Client> getAllClientByLogin(String login);
    String findClient(long id);
    void deleteClient(long id);
    List<Client> getClientId(long id);
    void updateClientRole(long id);
    Client findClientId (long id);
}
