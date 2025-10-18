package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        Delimiter delimiter = Delimiter.of(input);
        String[] numbers = parseNumbers(input, delimiter);

        int result = 0;
        for (String number : numbers) {
            result += Integer.parseInt(number);
        }

        System.out.println("결과 : " + result);
    }

    public static String[] parseNumbers(String input, Delimiter delimiter) {
        String numbersPart = input;
        if (input.startsWith("//")) {
            int end = input.indexOf("\\n");
            numbersPart = input.substring(end + 2);
        }
        return numbersPart.split(delimiter.getDelimiter());
    }
}
