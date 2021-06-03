import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {

		// START INIT
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String brackets = br.readLine();
		boolean isNotMatched = false;
		int result = 0;
		int sum = 1;
		
		Stack<Character> stackBrackets = new Stack<Character>();
		// END INIT

		// START CHECK BRACKETS
		for (int i = 0; i < brackets.length(); i++) {
			
			if (brackets.charAt(i) == '(') {			// OPEN BRACKETS (
				stackBrackets.add(brackets.charAt(i));
				sum *= 2;
			}
			if (brackets.charAt(i) == '[') {			// OPEN BRACKETS [
				stackBrackets.add(brackets.charAt(i));
				sum *= 3;
			}

			
			if (brackets.charAt(i) == ')') {			// CLOSE BRACKETS )
				if (stackBrackets.empty() || stackBrackets.peek() != '(') {
					isNotMatched = true;
					break;
				}

				if (brackets.charAt(i - 1) == '(') result += sum;
				
				stackBrackets.pop();
				sum /= 2;

			} else if (brackets.charAt(i) == ']') {		// CLOSE BRACKETS ]
				if (stackBrackets.empty() || stackBrackets.peek() != '[') {
					isNotMatched = true;
					break;
				}
				
				if (brackets.charAt(i - 1) == '[') result += sum;
				
				stackBrackets.pop();
				sum /= 3;
			}
		}
		// END   CHECK BRACKETS

		// RESULT
		if (isNotMatched == true || !stackBrackets.empty()) {
			System.out.println(0);
		} else {
			System.out.println(result);
		}
	}

}