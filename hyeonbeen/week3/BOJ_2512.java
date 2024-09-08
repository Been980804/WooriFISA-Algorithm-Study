package algorithm.hyeonbeen.week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.util.Arrays;

public class BOJ_2512 {
    
    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuffer sb = new StringBuffer();
    public static StringTokenizer st;

    public static int N, M, ans;
    public static int[] cost;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine()); // 지방의 수

        cost = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine()); // 총 예산

        Arrays.sort(cost); // 110 120 140 150

        int start = 0;              // 0원
        int end = cost[N - 1];      // 150원

        while (start <= end) {
            int mid = (start + end) / 2;    // mid = 현재 상한액
            int total = 0;

            for (int i = 0; i < N; i++) {
                if (mid < cost[i])          // 현재 상한액보다 크면 상한액으로 배정
                    total += mid;
                else                        // 아니면 요청금액 배정
                    total += cost[i];
            }

            if (total <= M) {               // total 이 총예산보다 작거나 같을시 현재 상한액 저장, 이진 탐색
                ans = mid;
                start = mid + 1;
            } else {                        
                end = mid - 1;
            }
        }
        System.out.println(ans);
    }
}
