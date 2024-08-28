package algorithm.hyeonbeen.week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Implementation1 {
    
    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());    // 테스트 데이터 개수

        for(int i = 0; i < N; i++){
            sb.append(func(br.readLine())+"\n");
        }
        System.out.println(sb);
    }

    public static String func (String str){
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);

            if(c == '('){                  // ( 인 경우 stack에 삽입
                stack.push(c);
            } else if(stack.isEmpty()){    // ) 이고 stack이 비어있을 경우 실패
                return "NO";
            } else{                        // ) 이고 stack에 값이 저장되어 있을 경우 () 짝 맞춤으로 pop
                stack.pop();
            }
        }

        if(stack.isEmpty()) return "YES";  // stack이 비어있을겨우 모두 짝이 맞음 
        else return "NO";                  // stack에 값이 저장되어 있을 경우 실패
    }
}
