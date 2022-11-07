package baseball.Domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static baseball.Constants.*;
import static baseball.Message.ExceptionMessage.*;

public class User {
    public static String userInput = "";
    public static String inputUserNumber() {
        String userInput = Console.readLine();
        checkedValidate(userInput);
        return userInput;
    }

    public static void checkedValidate(String input) {
        validateInputRange(input);
        checkDuplicatedNumber(input);
        validateContainZero(input);
    }
    public static void validateInputRange(String userInput) {
        String[] input = userInput.split("");
        if (input.length != 3) {
            throw new IllegalArgumentException(RANGE_ERR_MSG);
        }
    }
    public static void validateContainZero(String userInput) {
        if (userInput.contains("0")) {
            throw new IllegalArgumentException(CONTAIN_ZERO_ERR_MSG);
        }
    }
    public static void checkDuplicatedNumber (String userInput) {
        Set<String> userInputList = new HashSet<>(List.of(userInput.split("")));
        if (userInputList.size() != RESULT_SIZE) {
            throw new IllegalArgumentException(DUPLICATED_ERR_MSG);
        }
    }
}
