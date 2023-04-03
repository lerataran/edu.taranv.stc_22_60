package ru.src.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.src.web.dto.ClientDto;
import ru.src.web.model.Client;
import ru.src.web.repositories.ClientRepository;

@Service
public class SignUpServiceImpl implements SignUpService {
    private final ClientRepository clientRepository;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    public SignUpServiceImpl(ClientRepository clientRepository, PasswordEncoder passwordEncoder) {
        this.clientRepository = clientRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public void signUp(ClientDto dto) {
        Client client = Client.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .login(dto.getLogin())
                .password(passwordEncoder.encode(dto.getPassword()))
                .role(Client.Role.USER)
                .state(Client.State.CONFIRMED)
                .build();
        clientRepository.save(client);

        System.out.println("Аккаунт сохранен");
    }
}
