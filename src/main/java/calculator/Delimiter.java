package calculator;

public class Delimiter {
    private static final String DEFAULT_DELIMITER = "[,:]";
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\\n";
    private static final String REGEX_META_CHARACTERS = ".^$*+?()[]{}\\|";
    private static final int NOT_FOUND = -1;
    private final String delimiter;

    private Delimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    public static Delimiter of(String input) {
        if (!input.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            return new Delimiter(DEFAULT_DELIMITER);
        }

        int start = input.indexOf(CUSTOM_DELIMITER_PREFIX) + 2;
        int end = input.indexOf(CUSTOM_DELIMITER_SUFFIX);

        if (end == -1) {
            throw new IllegalArgumentException("커스텀 구분자 형식이 잘못되었습니다.");
        }

        String customDelimiter = input.substring(start, end);
        if (customDelimiter.isEmpty()) {
            throw new IllegalArgumentException("커스텀 구분자가 비어있습니다.");
        }

        String escapedDelimiter = escapeMetaCharacters(customDelimiter);
        return new Delimiter(escapedDelimiter);
    }

    private static String escapeMetaCharacters(String text) {
        String metaChars = REGEX_META_CHARACTERS;
        StringBuilder escaped = new StringBuilder();

        for (char c : text.toCharArray()) {
            if (metaChars.indexOf(c) != NOT_FOUND) {
                escaped.append('\\');
            }
            escaped.append(c);
        }

        return escaped.toString();
    }

    public String getDelimiter() {
        return delimiter;
    }
}
