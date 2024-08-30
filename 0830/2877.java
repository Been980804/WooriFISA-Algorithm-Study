import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();

        while (N > 0) {
            int m = N % 2;
            N = N / 2; 

            if (m == 0) { // 짝수면
                N -= 1; 
                result.insert(0, "7"); // 7을 왼쪽에 더하기
            } else { // 홀수면
                result.insert(0, "4"); // 4를 왼쪽에 더하기
            }
        }

        System.out.println(result.toString());
        br.close();
    }
}