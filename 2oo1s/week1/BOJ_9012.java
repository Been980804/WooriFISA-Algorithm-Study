import java.io.*;
import java.util.*;

public class boj_9012 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String str = br.readLine();
            Stack<Character> stk = new Stack<>();

            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                if (c == '(')
                    stk.add(c);
                else {
                    if (!stk.isEmpty() && stk.peek() == '(')
                        stk.pop();
                    else
                        stk.add(c);
                }
            }
            if (stk.isEmpty())
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
