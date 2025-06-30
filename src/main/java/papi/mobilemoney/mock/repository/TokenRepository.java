package papi.mobilemoney.mock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import papi.mobilemoney.mock.entity.Token;

public interface TokenRepository extends JpaRepository<Token,Long> {


}
