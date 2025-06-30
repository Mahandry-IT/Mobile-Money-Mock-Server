package papi.mobilemoney.mock.utis.classes;

import papi.mobilemoney.mock.data.enums.MobileMoneyOperator;
import papi.mobilemoney.mock.data.exception.MobileMoneyException;

import java.lang.reflect.Field;

public class ReflectionUtils {

    public static void checkFieldValue(MobileMoneyOperator operator, Object obj) {
        Class<?> current = obj.getClass();

        while (current != null && current != Object.class) {
            Field[] declaredFields = current.getDeclaredFields();

            for (Field field : declaredFields) {
                field.setAccessible(true);

                try {
                    Object value = field.get(obj);
                    if (value == null) {
                        throw new MobileMoneyException(operator,
                                "Missing field",
                                String.format("The field '%s' is required for this request.", field.getName()));
                    }
                } catch (IllegalAccessException e) {
                    new RuntimeException("Unable to access field : " + field.getName());
                }
            }

            current = current.getSuperclass();
        }
    }


}
