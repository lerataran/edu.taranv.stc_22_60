package ru.src.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.src.web.model.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "select * from product, cart where product.id = cart.product_id", nativeQuery = true) //nativeQuery = true - включили SQL синтаксис
    List<Product> getAllByCart();
}
