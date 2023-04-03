package ru.src.web.dto;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.src.web.model.Client;
import ru.src.web.model.Product;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {
    private @NotNull Client client;
    private @NotNull Product product;

}
