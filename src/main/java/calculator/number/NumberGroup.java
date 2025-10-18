package calculator.number;

import calculator.Delimiter;
import java.util.Arrays;
import java.util.List;

public class NumberGroup {
    private final List<ValidatedNumber> numbers;

    private NumberGroup(List<ValidatedNumber> numbers) {
        this.numbers = numbers;
    }

    public static NumberGroup of(String input, Delimiter delimiter) {
        String numberPart = extractNumberPart(input);

        if (numberPart.isEmpty()) {
            throw new IllegalArgumentException("숫자가 입력되지 않았습니다.");
        }

        String[] parts = numberPart.split(delimiter.getDelimiter());

        List<ValidatedNumber> numberList = Arrays.stream(parts)
                .map(String::trim)
                .map(ValidatedNumber::new)
                .toList();

        return new NumberGroup(numberList);
    }

    private static String extractNumberPart(String input) {
        if (input.startsWith("//")) {
            int end = input.indexOf("\\n");
            return input.substring(end + 2);
        }
        return input;
    }

    public int sum() {
        return numbers.stream()
                .mapToInt(ValidatedNumber::value)
                .sum();
    }
}
