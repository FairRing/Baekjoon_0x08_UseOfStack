import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            sb.append(verifyBrackets(br.readLine())).append('\n');
        }

        System.out.println(sb);
    }

    public static String verifyBrackets(String s) {

        Stack<Character> openBrackets = new Stack<Character>();

        // START VERIFY
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                openBrackets.push(c);
            } else {
                if (openBrackets.empty()) {
                    return "NO";
                } else {
                    openBrackets.pop();
                }
            }
        }
        // END VERIFY

        // AFTER VERFIYING
        if (openBrackets.empty()) return "YES";
        else return "NO";
    }
}