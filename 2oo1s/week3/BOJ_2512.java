import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] nation = new int[n];
        int maxCost = 0;
        int sum = 0;
        int cost;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            nation[i] = Integer.parseInt(st.nextToken());

            sum += nation[i];
            maxCost = Math.max(maxCost, nation[i]);
        }

        int m = Integer.parseInt(br.readLine()); // 최대 예산

        if (m >= sum)
            System.out.println(maxCost);
        else {
            int s = -1;

            while (s < maxCost - 1) {
                int mid = (s + maxCost) / 2;
                cost = 0;

                for (int i : nation)
                    cost += Math.min(mid, i);

                if (cost > m)
                    maxCost = mid;
                else
                    s = mid;
            }
            System.out.println(s);
        }
    }
}
