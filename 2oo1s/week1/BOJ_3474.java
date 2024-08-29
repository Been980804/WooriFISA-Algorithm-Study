import java.io.*;

public class boj_3474 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        // 팩토리얼 연산에서 5가 얼마나 존재하는지 구하면 됨
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int cnt = 0;

            for (int j = 5; j <= n; j *= 5)
                cnt += n / j;

            System.out.println(cnt);
        }
    }
}
