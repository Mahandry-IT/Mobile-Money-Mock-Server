package papi.mobilemoney.mock.data.response.mobilemoney;

import lombok.Data;

@Data
public class MobileMoneyTokenResponse {

    String access_token;
    String token_type;
    int expires_in;

}
