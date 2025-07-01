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

    @Column(name = "expires_at", nullable = false)
    private LocalDateTime expiresAt;

    @Column(name = "token_type", nullable = false)
    private String tokenType;

    @Column(name = "provider_code", nullable = false)
    private String providerCode;
}
