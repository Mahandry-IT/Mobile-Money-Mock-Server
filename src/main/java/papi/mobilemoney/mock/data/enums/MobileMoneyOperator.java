package papi.mobilemoney.mock.data.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MobileMoneyOperator {

    ORANGE_MONEY("Orange Money", "ORANGE_MONEY"),
    AIRTEL_MONEY("Airtel Money", "AIRTEL_MONEY"),
    MVOLA("MVola", "MVOLA");

    private final String name;
    private final String code;

    public static MobileMoneyOperator fromCode(String code) {
        for (MobileMoneyOperator operator : values()) {
            if (operator.code.equalsIgnoreCase(code)) {
                return operator;
            }
        }
        throw new RuntimeException("Unknown Mobile Money operator code: " + code);
    }

}
