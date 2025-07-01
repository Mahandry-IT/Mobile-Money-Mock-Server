package papi.mobilemoney.mock.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import papi.mobilemoney.mock.configuration.token.TokenProperties;
import papi.mobilemoney.mock.data.enums.MobileMoneyOperator;
import papi.mobilemoney.mock.data.exception.MobileMoneyException;
import papi.mobilemoney.mock.entity.Token;
import papi.mobilemoney.mock.repository.TokenRepository;
import papi.mobilemoney.mock.utis.session.TokenHandler;

import java.util.Map;

@Service
public class TokenService {

    @Autowired
    private TokenRepository tokenRepository;

    @Autowired
    private TokenProperties tokenProperties;

    @Transactional
    public void createToken(MobileMoneyOperator operator,
                               int tokenValidity,
                               String token,
                               String header,
                               Map<String, String> headers,
                               String regex) {
        String authorization =  headers.get(header.toLowerCase());
        if(authorization == null || authorization.isEmpty()){
            throw new MobileMoneyException(MobileMoneyOperator.MVOLA,
                    "invalid_client",
                    String.format("We need our %s in the header.", header));
        }

        //Split the header to get the token
        String[] parts = TokenHandler.getTokenFromHeader(authorization, regex);
        checkClientAuthorization(operator, parts[1]);

        // Setting up the token entity to save in the database
        Token entity = new Token();
        entity.setAccessToken(token);
        entity.setTokenType("Bearer");
        entity.setProviderCode(operator.getCode());
        entity.setExpiresAt(TokenHandler.addSecondNow(tokenValidity));

        tokenRepository.save(entity);
    }

    private void checkClientAuthorization(MobileMoneyOperator operator, String authorization){
        String clientAuth = tokenProperties.getAuthorization().getMvola();
        if (clientAuth.compareTo(authorization) != 0) {
            throw new MobileMoneyException(operator,
                    "Invalid client authentication",
                    "invalid_client");
        }
    }

}
