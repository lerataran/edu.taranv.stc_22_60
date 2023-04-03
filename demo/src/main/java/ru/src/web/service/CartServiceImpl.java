package ru.src.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import ru.src.web.model.Cart;
import ru.src.web.model.Client;
import ru.src.web.model.Product;
import ru.src.web.repositories.CartRepository;
import ru.src.web.repositories.ClientRepository;
import ru.src.web.repositories.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService{
    private final CartRepository cartRepository;
    private final ClientRepository clientRepository;
    private final ProductRepository productRepository;
    @Autowired
    public CartServiceImpl(CartRepository cartRepository, ClientRepository clientRepository, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.clientRepository = clientRepository;
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllCartById(long id) {
        List<Cart> carts = cartRepository.getAllCartById(id);
        List<Product> products = productRepository.findAll();
        List<Product> rest = new ArrayList<>();
        int x = 0;
        for (int i = 0; i < products.size(); i++) {
            if (carts.get(i).getProductId() == products.get(i).getId()) {
                rest.add(x,products.get(i));
                x++;
            }
        }
        return rest;
    }

    public List<Cart> getAllCart(long id) {
        Optional<Cart> cart = cartRepository.findById(id);
        List<Cart> rest = new ArrayList<>();
        cart.ifPresent(rest::add);
        return rest;
    }
    @Override
    public void addCart(Authentication authentication, long id) {
        Client client = clientRepository.getClientByLogin(authentication.getName()).orElseThrow();
        long clientId = client.getId();
        Cart cart = Cart.builder()
                .productId(id)
                .clientId(clientId)
                .build();
       cartRepository.save(cart);

        System.out.println("Добавлено в корзину");
    }
}
