import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
    
        // initialize start
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // string 
        String originString = ""; // target : 1line
        String[] arrayOriginString = null;
        Stack<String> stackBracket = null;

        List<String> listResult = null;


    






        // initialize end


        // set input start
        while (true) {
            
            originString = br.readLine(); // 1.set originString
            listResult = new ArrayList<String>();

            if ((originString.length() == 1) && (originString.equals("."))) {// 입력의 종료조건으로 맨 마지막에 점 하나(".")가 들어온다.
                break;
            }

            if (originString.length() > 0) {
                arrayOriginString = originString.split(""); // 2. convert String to String[]
                stackBracket = new Stack<String>();

                for (int i = 0; i < arrayOriginString.length; i++) {
                    if ( arrayOriginString[i].equals("(") || arrayOriginString[i].equals(")")|| 
                         arrayOriginString[i].equals("[") || arrayOriginString[i].equals("]") ) {
                        
                        stackBracket.push(arrayOriginString[i]);
                    }
                }

                /* # check start #
                   1. (1),(2) : 스택사이즈는 홀수이면 실패
                   2. (3),(4) : 각 '(', ')'끼리,  '[', ']'끼리는 사이즈가 다르면 실패
                   
                   5, 6, 7 ??
                
                */ 
                while (true) {



                    if ((stackBracket.pop().equals(")")) || (stackBracket.pop().equals("]"))) {
                        
                    }




                    if (stackBracket.isEmpty()) {
                        listResult.add("yes");
                        break;
                    } else {
                        if (stackBracket.size()%2 == 1) {
                            listResult.add("no");
                            break;
                        } else {
                            if ((stackBracket.peek().equals("(")) || (stackBracket.peek().equals("[(]"))) {
                                stackBracket.pop();
                                listResult.add("no");
                                break;
                            } else {
                                
                            }
                             
                        }
                    }
                }

                

            } else {
                continue;
            }





            for (int i = 0; i < arrayOriginString.length; i++) {
                System.out.print("\t");    
                System.out.print(arrayOriginString[i]);    
            }
            
        }




        // set input end

        // set output start
        bw.write(originString);
        bw.flush();
        bw.close();
        // set output end
        
        // result
    }
}
