import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String braces = br.readLine();
            String answer = "NO";
            int count = 0;

            if (braces.length() > 0 && braces.charAt(0) == ')') {
                System.out.println(answer);
                continue;
            }

            for (char brace : braces.toCharArray()) {
                if (brace == '(') {
                    count++;
                } else {
                    count--;
                }
                if (count < 0) {
                    break;
                }
            }

            if (count == 0) {
                answer = "YES";
            }

            System.out.println(answer);
        }

        br.close();
    }
}