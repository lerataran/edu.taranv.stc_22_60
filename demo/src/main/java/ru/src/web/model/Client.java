package ru.src.web.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String login;
    private String password;
    @OneToOne
    private Cart cart;
    @Enumerated(value = EnumType.STRING)
    private Role role;
    @Enumerated(value = EnumType.STRING)
    private State state;

    public enum State {
        NOT_CONFIRMED, CONFIRMED, BANNED, DELETED
    }

    public enum Role {
        ADMIN, USER
    }

}

