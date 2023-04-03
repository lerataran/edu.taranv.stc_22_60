package ru.src.web.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "price", nullable = false)
    private int price;
    @Column(name = "img", nullable = false)
    private String img;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private List<Cart> carts;

}
