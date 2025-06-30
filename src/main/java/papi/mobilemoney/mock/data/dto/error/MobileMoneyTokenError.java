package papi.mobilemoney.mock.data.dto.error;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MobileMoneyTokenError {

    String error_description;
    String error;

}
