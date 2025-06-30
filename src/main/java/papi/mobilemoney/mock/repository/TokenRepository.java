package papi.mobilemoney.mock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import papi.mobilemoney.mock.entity.Token;

import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token,Long> {

    Optional<Token> findByAccessToken(String token);
}
