package ru.src.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.src.web.model.Client;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findByLogin(String login);
    @Query(value = "select * from client where login = :login", nativeQuery = true) //nativeQuery = true - включили SQL синтаксис
    List<Client> getAllByLogin(@Param("login") String login);
    @Query(value = "select * from client where login = :login", nativeQuery = true) //nativeQuery = true - включили SQL синтаксис
    Optional<Client> getClientByLogin(@Param("login") String login);
    List<Client> findAllByState(Client.State state);
    @Query(value = "select * from client where id = :id", nativeQuery = true)
    Client findId (long id);
}
