package ru.src.web.service;

import org.springframework.security.core.Authentication;
import ru.src.web.model.Cart;
import ru.src.web.model.Product;

import java.util.List;

public interface CartService {
    List<Product> getAllCartById(long id);
    List<Cart> getAllCart(long id);
    void addCart(Authentication authentication, long id);
}
