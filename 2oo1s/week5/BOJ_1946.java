import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {
            int n = Integer.parseInt(br.readLine());    // 지원자 수
            int[] emp = new int[n + 1];
            int ans = 1;

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                emp[a] = b;
            }

            int cur = emp[1];

            // 면접 순위가 현재 면접 순위보다 높으면(= value 값이 작으면) 신입사원 수 +1 해줌
            for (int i = 2; i <= n; i++) {
                if (emp[i] < cur) {
                    cur = emp[i];
                    ans++;
                }
            }
            System.out.println(ans);
        }
    }
}

/*
1 4
2 3
3 2
4 1
5 5
 */
