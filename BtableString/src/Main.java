import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int no = 1;

        while (true) {
            String brace = br.readLine();
            
            if (brace.contains("-")) break;

            int braceLenth = brace.length();
            int count = 0;

            Stack<Character> braces = new Stack<>();

            for (int i = 0; i < braceLenth; i++) {
                char tmp = brace.charAt(i);
                if (tmp == '{') {
                    braces.add(tmp);
                } else {
                    if (braces.isEmpty()) {
                        count++;
                        braces.add('{');
                    } else
                        braces.pop();
                }
            }
            bw.write((no++) + ". " + (count + braces.size() / 2) + "\n");
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
}