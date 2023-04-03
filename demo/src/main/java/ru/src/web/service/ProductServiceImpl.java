package ru.src.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.src.web.dto.ProductDto;
import ru.src.web.model.Product;
import ru.src.web.repositories.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }
    @Override
    public void addProduct(ProductDto dto) {
        Product product = Product.builder()
                .title(dto.getTitle())
                .img(dto.getImg())
                .price(Integer.parseInt(dto.getPrice())).build();
        productRepository.save(product);

        System.out.println("Товар сохранен");
    }

    @Override
    public List<Product> detailsProduct(long id) {
        Optional <Product> product = productRepository.findById(id);
        List<Product> rest = new ArrayList<>();
        product.ifPresent(rest::add);
        return rest;
    }

    @Override
    public void updateProduct(long productId, ProductDto productDto) {
       Product product = productRepository.findById(productId).orElseThrow();
       product.setTitle(productDto.getTitle());
       product.setPrice(Integer.parseInt(productDto.getPrice()));
       product.setImg(productDto.getImg());
       productRepository.save(product);

       System.out.println("Товар изменен");
    }

    @Override
    public void deleteProduct(long productId) {
        Product product = productRepository.findById(productId).orElseThrow();
        productRepository.delete(product);
    }

    @Override
    public List<Product> getAllCart() {
        return productRepository.getAllByCart();
    }
}
