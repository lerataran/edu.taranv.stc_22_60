package web.service;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;
import web.dto.ClientDto;
import web.model.Client;
import web.repositories.ClientRepository;


@Service
public class SignUpServiceImpl implements SignUpService {
    private final ClientRepository clientRepository;
    @Autowired
    public SignUpServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public void signUp(ClientDto dto) {
        Client client = Client.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .login(dto.getLogin())
                .password(dto.getPassword())
                .build();
        clientRepository.save(client);

        System.out.println("Аккаунт сохранен");
    }
}
