package papi.mobilemoney.mock.data.enums;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public enum MobileMoneyOperator {

    ORANGE_MONEY("Orange Money", "OM"),
    AIRTEL_MONEY("Airtel Money", "AM"),
    MVOLA("MVOLA", "MV");

    private final String name;
    private final String code;

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public static MobileMoneyOperator fromCode(String code) {
        for (MobileMoneyOperator operator : values()) {
            if (operator.code.equalsIgnoreCase(code)) {
                return operator;
            }
        }
        throw new RuntimeException("Unknown Mobile Money operator code: " + code);
    }

}
