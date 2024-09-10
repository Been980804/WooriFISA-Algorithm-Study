import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] dp = new int[N + 1];

            for (int i = 1; i <= N; i++) {
                if (i == 1) {
                    dp[i] = 1;
                } else if (i == 2) {
                    dp[i] = 2;
                } else if (i == 3) {
                    dp[i] = 4;
                } else {
                    dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
                }
            }

            System.out.println(dp[N]);
        }
    }
}