package calculator;

import calculator.number.NumberGroup;

public class StringAddCalculator {

    public static int calculate(String input) {
        if (input.isBlank()) {
            return 0;
        }

        Delimiter delimiter = Delimiter.of(input);
        NumberGroup numberGroup = NumberGroup.of(input, delimiter);

        return numberGroup.sum();
    }
}
