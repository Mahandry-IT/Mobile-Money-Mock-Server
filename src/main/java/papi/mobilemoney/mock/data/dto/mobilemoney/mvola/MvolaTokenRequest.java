package papi.mobilemoney.mock.data.dto.mobilemoney.mvola;

import lombok.Data;
import papi.mobilemoney.mock.data.dto.mobilemoney.MobileMoneyTokenRequest;

@Data
public class MvolaTokenRequest extends MobileMoneyTokenRequest {

    String scope;

}
