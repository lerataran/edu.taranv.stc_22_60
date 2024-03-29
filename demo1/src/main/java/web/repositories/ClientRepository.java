package web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.model.Client;


@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
