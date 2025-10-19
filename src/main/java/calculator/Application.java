package calculator;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String line = Console.readLine();
        String sep = ":|,";
        long result = 0L;

        // 커스텀 구분자 설정
        if (line.startsWith("//")) {
            String customSep = line.substring(2);
            customSep = java.util.regex.Pattern.quote(customSep);
            sep = sep + "|" + customSep;
            line = Console.readLine();
        }

        String[] opd = line.split(sep);
        for (String op : opd) {
            if (op.equals("")) continue;
            if (!op.matches("\\d+")) {
                throw new IllegalArgumentException("피연산자 입력이 잘못되었습니다.");
            }
            result += Long.parseLong(op);
        }

        System.out.println("결과 : " + result);
    }
}
