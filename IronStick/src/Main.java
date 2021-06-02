import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
 
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        
        String brackets = br.readLine(); // 입력받을 괄호들
        String[] arrayBrackets = brackets.split("");
        Stack<String> lazer = new Stack<>(); // 막대기의 시작인 (를 담아서, ()조건이 성립[레이저]되면 현재 시작된[막대기의 끝은 모르지만] 막대개를 자르는 용도임
        int cutSticks = 0; // 레이저로 잘린 막대기(결과)

        for (int i = 0; i <  arrayBrackets.length; i++) {
            if (arrayBrackets[i].equals("(")) {
                lazer.push(arrayBrackets[i]);
            } else {
                lazer.pop(); // 상위 조건으로 )게 나오면 일단 레이저성립조건을 확인하기위해 pop()함

                if (arrayBrackets[i-1].equals("(")) { // 레이저 성립조건임 --> 잘림
                    cutSticks = cutSticks+lazer.size();
                } else { // 막대기 끝부분임 결과에 +1
                    cutSticks++;
                }
            }
        }



        bw.write(cutSticks + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
 
}
 
