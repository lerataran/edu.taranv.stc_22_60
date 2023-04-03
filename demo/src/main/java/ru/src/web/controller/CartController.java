package ru.src.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.src.web.model.Client;
import ru.src.web.model.Product;
import ru.src.web.service.CartService;
import ru.src.web.service.ClientService;

import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;
    private final ClientService clientService;

    @Autowired
    public CartController(CartService cartService, ClientService clientService) {
        this.cartService = cartService;
        this.clientService = clientService;

    }

    @GetMapping("/{id}")
    public String getCartPage(@PathVariable(value = "id") long id, Model model) {
        List<Product> products = cartService.getAllCartById(id);
        List<Client> clients = clientService.getClientId(id);
        model.addAttribute("product", products);
        model.addAttribute("client", clients);
        return "cart";
    }
    @PostMapping("/{id}/pro")
    public String CartDelete(@PathVariable(value = "id") long id) {
        if (clientService.findClient(id).equals("USER")) {
            return "redirect:/productsUser";
        }
        return "redirect:/products";
    }
    @PostMapping("/{id}/add")
    public String CartAdd(@PathVariable(value = "id") long id, Authentication authentication) {
    cartService.addCart(authentication,id);
            return "redirect:/";
    }
}
