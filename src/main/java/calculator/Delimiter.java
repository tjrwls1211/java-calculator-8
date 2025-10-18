package calculator;

public class Delimiter {
    private static final String DEFAULT_DELIMITER = "[,:]";
    private final String delimiter;

    private Delimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    public static Delimiter of(String input) {
        if (!input.startsWith("//")) {
            return new Delimiter(DEFAULT_DELIMITER);
        }

        int start = input.indexOf("//") + 2;
        int end = input.indexOf("\\n");

        if (end == -1) {
            throw new IllegalArgumentException("커스텀 구분자 형식이 잘못되었습니다.");
        }

        String customDelimiter = input.substring(start, end);
        if (customDelimiter.isEmpty()) {
            throw new IllegalArgumentException("커스텀 구분자가 비어있습니다.");
        }

        return new Delimiter("[,:" + customDelimiter + "]");
    }

    public String getDelimiter() {
        return delimiter;
    }
}
