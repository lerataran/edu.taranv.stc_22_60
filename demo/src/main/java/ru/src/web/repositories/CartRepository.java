package ru.src.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.src.web.model.Cart;

import java.util.List;


@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    @Query(value = "select * from cart  where cart.client_id = :id", nativeQuery = true)
    List<Cart> getAllCartById(@Param("id") long id);
}
