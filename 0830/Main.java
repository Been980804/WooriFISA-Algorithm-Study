import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine()); // 수 입력 받기
            int count = 0;
            for (int i = 5; i <= n; i *= 5) {
                count += n / i; // 5의 배수의 합을 구한다
            }
            System.out.println(count);
        }

        br.close();
    }
}