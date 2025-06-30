package papi.mobilemoney.mock.services.mvola.token;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import papi.mobilemoney.mock.configuration.token.TokenProperties;
import papi.mobilemoney.mock.data.dto.mobilemoney.mvola.MvolaTokenRequest;
import papi.mobilemoney.mock.data.enums.MobileMoneyOperator;
import papi.mobilemoney.mock.data.exception.MobileMoneyException;
import papi.mobilemoney.mock.data.response.mobilemoney.mvola.MvolaTokenResponse;
import papi.mobilemoney.mock.entity.Token;
import papi.mobilemoney.mock.repository.TokenRepository;
import papi.mobilemoney.mock.services.TokenService;
import papi.mobilemoney.mock.utis.classes.ReflectionUtils;
import papi.mobilemoney.mock.utis.session.TokenHandler;

import java.util.Map;

@Service
public class MvolaTokenService {

    @Autowired
    private TokenProperties tokenProperties;

    @Autowired
    private TokenService tokenService;

    public MvolaTokenResponse createMvolaToken(MvolaTokenRequest request, Map<String, String> headers) {
        if (tokenProperties.getIdentity().getGrantType().compareTo(request.getGrant_type()) != 0) {
            throw new MobileMoneyException(MobileMoneyOperator.MVOLA,
                    "Invalid grant type",
                    "invalid_client");
        }

        ReflectionUtils.checkFieldValue(MobileMoneyOperator.MVOLA, request);
        if (headers == null || headers.isEmpty()){
            throw new MobileMoneyException(MobileMoneyOperator.MVOLA,
                    "Your header is empty",
                    "invalid_client");
        }

        //Get the expiration time
        int validity = tokenProperties.getValidity().getMvola();

        //Setup the expiration time or change to default value
        int expires_in = validity != 0 ? validity : 3600;

        // Generate token
        String token = TokenHandler.generateToken(tokenProperties.getByteLength());

        // Get the scope for the request or change to default value
        String scope = !request.getScope().isEmpty() ? request.getScope() : "default" ;

        // Setting up the response
        MvolaTokenResponse response = new MvolaTokenResponse();
        response.setAccess_token(token);
        response.setExpires_in(expires_in);
        response.setScope(scope);
        response.setToken_type("Bearer");

        tokenService.createToken(
                MobileMoneyOperator.MVOLA,
                validity,
                token,
                "authorization",
                headers,
                " "
        );

        return response;
    }

}
