package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        int result = 0;
        if (!input.isBlank()) {
            String delimiter = "[,:]";
            String numbers = input;

            if (input.startsWith("//")) {
                int start = input.indexOf("//") + 2;
                int end = input.indexOf("\\n");

                if (end == -1) {
                    throw new IllegalArgumentException("커스텀 구분자 형식이 잘못되었습니다.");
                }

                String customDelimiter = input.substring(start, end);
                if (customDelimiter.isEmpty()) {
                    throw new IllegalArgumentException("커스텀 구분자가 비어있습니다.");
                }

                delimiter = "[,:" + customDelimiter + "]";
                numbers = input.substring(end + 2);

                if (numbers.isEmpty()) {
                    throw new IllegalArgumentException("숫자가 입력되지 않았습니다.");
                }
            }

            String[] numberStrings = numbers.split(delimiter);
            for (String numberText : numberStrings) {
                numberText = numberText.trim();
                if (numberText.isEmpty()) {
                    throw new IllegalArgumentException("잘못된 입력입니다.");
                }

                int number;
                try {
                    number = Integer.parseInt(numberText);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다: ");
                }

                if (number < 0) {
                    throw new IllegalArgumentException("음수는 허용되지 않습니다: ");
                }

                result += number;
            }
        }

        System.out.println("결과 : " + result);
    }
}
