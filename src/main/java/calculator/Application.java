package calculator;

import calculator.number.NumberGroup;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        try {
            Delimiter delimiter = Delimiter.of(input);
            NumberGroup numberGroup = NumberGroup.of(input, delimiter);
            int result = numberGroup.sum();

            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
    }
}
