package ru.src.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.src.web.dto.ProductDto;
import ru.src.web.model.Client;
import ru.src.web.model.Product;
import ru.src.web.service.ClientService;
import ru.src.web.service.ProductService;

import java.util.List;

@Controller
@RequestMapping
public class ProductController {
    private final ProductService productService;
    private final ClientService clientService;
    @Autowired
    public ProductController(ProductService productService, ClientService clientService) {
        this.productService = productService;
        this.clientService = clientService;
    }
    @GetMapping("/products")
    public String getAllProducts(Authentication authentication, Model model) {
        List<Product> products = productService.getAllProduct();
        List<Client> clients = clientService.getAllClientByLogin(authentication.getName());
        model.addAttribute("products", products);
        model.addAttribute("client", clients);
        return "products";
    }
    @GetMapping("/productsUser")
    public String getAllProductsUser(Authentication authentication, Model model) {
        List<Product> products = productService.getAllProduct();
        List<Client> clients = clientService.getAllClientByLogin(authentication.getName());
        model.addAttribute("products", products);
        model.addAttribute("client", clients);
        return "productsUser";
    }
    @GetMapping("/oneProducts")
    public String getAllProductsNot(Model model) {
        List<Product> products = productService.getAllProduct();
        model.addAttribute("products", products);
        return "productsNot";
    }
    @GetMapping("/addProducts")
    public String getAddProductPage() {
        return "addProducts";
    }
    @PostMapping("/addProducts")
    public void addProduct(ProductDto dto) {
        productService.addProduct(dto);
    }
    @GetMapping("/products/{id}")
    public String getProductDetails(@PathVariable (value = "id") long id, Model model) {
        List<Product> product = productService.detailsProduct(id);
        model.addAttribute("detals", product);
        return "oneProduct";
    }
    @GetMapping("/productsUser/{id}")
    public String getProductDetailsUser(@PathVariable (value = "id") long id, Model model) {
        List<Product> product = productService.detailsProduct(id);
        model.addAttribute("detals", product);
        return "oneProductsUser";
    }
    @GetMapping("/oneProducts/{id}")
    public String getProductDetailsNot(@PathVariable (value = "id") long id, Model model) {
        List<Product> product = productService.detailsProduct(id);
        model.addAttribute("detals", product);
        return "oneProductNot";
    }
    @GetMapping("/products/{id}/edit")
    public String getProductEdit(@PathVariable (value = "id") long id, Model model) {
        List<Product> product = productService.detailsProduct(id);
        model.addAttribute("detals", product);
        return "productEdit";
    }
    @PostMapping("/products/{id}/edit")
    public String ProductEdit(@PathVariable (value = "id") long id, ProductDto dto) {
        productService.updateProduct(id,dto);
        return "redirect:/products";
    }

    @PostMapping("/products/{id}/del")
    public String ProductDelete(@PathVariable (value = "id") long id) {
        productService.deleteProduct(id);
        return "redirect:/products";
    }


}
