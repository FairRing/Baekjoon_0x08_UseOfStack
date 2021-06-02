import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String iputLine;

        while (true) {
            iputLine = br.readLine();
            if (iputLine.equals(".")) break; // 입력 종료 조건임

            sb.append(verifyLine(iputLine)).append('\n');
        }

        System.out.println(sb);
    }

    // 라인별 괄호 체크
    public static String verifyLine(String s) {

        Stack<Character> brackets = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '[')  brackets.push(c); // [, ( 이면 push()
                
            // CLOSE CASE ")"
            else if (c == ')') {
                if (brackets.empty() || brackets.peek() != '(') { // 스택이 빈경우 & "()"게 안되는경우
                    return "no";
                } else {
                    brackets.pop();
                }
            }

            // CLOSE CASE "]"
            if (c == ']') {
                if (brackets.empty() || brackets.peek() != '[') { // 스택이 빈경우 & "[]"게 안되는경우
                    return "no";
                } else {
                    brackets.pop();
                }
            }
        }

        if (brackets.empty()) {
            return "yes";
        } else {
            return "no";
        }
    }

}