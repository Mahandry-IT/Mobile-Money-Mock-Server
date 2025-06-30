package papi.mobilemoney.mock.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "token")
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idtoken;

    @Column(name = "access_token", nullable = false, unique = true)
    private String accessToken;

    @Column(nullable = false)
    private LocalDateTime expires_at;

    @Column(name = "token_type", nullable = false)
    private String tokenType;
}
