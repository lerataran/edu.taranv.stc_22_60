package ru.src.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.src.web.model.Product;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private String title;
    private String price;
    private String img;
    public static ProductDto from(Product product) {
        return ProductDto.builder()
                .img(product.getImg())
                .price(String.valueOf(product.getPrice()))
                .title(product.getTitle())
                .build();
    }

}
