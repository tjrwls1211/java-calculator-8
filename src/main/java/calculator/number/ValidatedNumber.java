package calculator.number;

public class ValidatedNumber {

    private final int value;

    public ValidatedNumber(String text) {
        if (text.isEmpty()) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

        try {
            this.value = Integer.parseInt(text);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다: " + text);
        }

        if (value < 0) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다: " + value);
        }
    }

    public int value() {
        return value;
    }
}
