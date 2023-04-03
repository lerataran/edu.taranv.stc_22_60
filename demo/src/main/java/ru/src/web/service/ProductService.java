package ru.src.web.service;

import ru.src.web.dto.ProductDto;
import ru.src.web.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProduct();
    void addProduct(ProductDto dto);
    List<Product> detailsProduct(long id);
    void updateProduct(long productId, ProductDto productDto);
    void deleteProduct(long productId);

    List<Product> getAllCart();

}
