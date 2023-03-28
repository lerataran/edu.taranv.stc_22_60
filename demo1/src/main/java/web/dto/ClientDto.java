package web.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {
    private String firstName;
    private String lastName;
    private String login;
    private String password;
}

