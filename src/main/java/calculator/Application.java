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
                String customDelimiter = input.substring(start, end);
                delimiter = "[,:" + customDelimiter + "]";
                numbers = input.substring(end + 2);
            }

            String[] numberStrings = numbers.split(delimiter);
            for (String numberText : numberStrings) {
                numberText = numberText.trim();
                if (numberText.isEmpty()) {
                    continue;
                }
                result += Integer.parseInt(numberText);
            }
        }

        System.out.println("결과 : " + result);
    }
}
