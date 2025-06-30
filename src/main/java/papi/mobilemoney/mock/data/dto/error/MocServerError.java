package papi.mobilemoney.mock.data.dto.error;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MocServerError {

    int status;
    String error;
    String message;
    String path;
}
