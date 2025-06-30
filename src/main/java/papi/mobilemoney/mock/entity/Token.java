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

    @Column(nullable = false, unique = true)
    private String access_token;

    @Column(nullable = false)
    private LocalDateTime expires_at;

    @Column(nullable = false)
    private String token_type;
}
