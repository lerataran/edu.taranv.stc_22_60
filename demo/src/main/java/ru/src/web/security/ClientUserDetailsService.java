package ru.src.web.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.src.web.repositories.ClientRepository;

@Service
public class ClientUserDetailsService implements UserDetailsService {
    private final ClientRepository clientRepository;

    public ClientUserDetailsService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return new ClientUserDetails(
                clientRepository.findByLogin(login)
                        .orElseThrow(() -> new UsernameNotFoundException("Аккаунт не найдент"))
        );
    }
}
