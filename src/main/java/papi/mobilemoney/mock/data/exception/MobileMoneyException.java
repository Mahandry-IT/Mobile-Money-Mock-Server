package papi.mobilemoney.mock.data.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import papi.mobilemoney.mock.data.enums.MobileMoneyOperator;

@Data
@AllArgsConstructor
public class MobileMoneyException extends RuntimeException {

    private final MobileMoneyOperator operator;
    private final String message;
    private final String title;
    private final Throwable cause;

    public MobileMoneyException(MobileMoneyOperator operator, String message, String title) {
        super(message);
        this.operator = operator;
        this.message = message;
        this.title = title;
        this.cause = null;
    }

}
