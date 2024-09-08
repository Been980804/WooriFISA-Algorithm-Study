import java.io.*;
import java.util.*;

public class BOJ_2110 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());   // 집 수
        int c = Integer.parseInt(st.nextToken());   // 공유기 수

        int ans = 0;
        int[] home = new int[n];

        for (int i = 0; i < n; i++)
            home[i] = Integer.parseInt(br.readLine());

        Arrays.sort(home);

        int s = 0;
        int e = home[n - 1] - home[0];

        while (s <= e) {
            int mid = (s + e) / 2;

            int pos = 0;
            int cnt = 1;

            for (int i = 1; i < n; i++) {
                if (home[i] - home[pos] >= mid) {
                    pos = i;
                    cnt++;
                }
            }

            if (cnt >= c) {
                ans = mid;
                s = mid + 1;
            } else
                e = mid - 1;
        }
        System.out.println(ans);
    }
}
