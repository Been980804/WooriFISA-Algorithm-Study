import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        int ans;

        for (int t = 0; t < tc; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            ans = 0;

            int[] a = new int[n];
            int[] b = new int[m];

            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++)
                a[j] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++)
                b[j] = Integer.parseInt(st.nextToken());

            Arrays.sort(b);
            for (int i : a) {
                int s = 0;
                int e = m - 1;
                int cnt = 0;

                while (s <= e) {
                    int mid = (s + e) / 2;
                    if (i > b[mid]) {
                        s = mid + 1;
                        cnt = mid + 1;
                    } else
                        e = mid - 1;
                }
                ans += cnt;
            }
            System.out.println(ans);
        }
    }
}
/*
5 3
1 1 3 7 8
 */
