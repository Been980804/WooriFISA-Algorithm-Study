package algorithm.hyeonbeen.week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9095 {
    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuffer sb = new StringBuffer();
    public static StringTokenizer st;

    public static int[] dp;

    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine()); // 합으로 나타낼 수

            dp = new int[num + 1];

            if (num <= 0)                               // 런타임 에러.. why? -> num이 0,1,2 보다 작을경우 초기화 부분에서 error 떳었음
                sb.append(1).append("\n");
            else if (num <= 1)
                sb.append(1).append("\n");
            else {
                dp[0] = 1;
                dp[1] = 1;
                dp[2] = 2;

                for (int j = 3; j <= num; j++) {
                    dp[j] = dp[j - 1] + dp[j - 2] + dp[j - 3];      // 3부터 시작해서 +1, +2, +3 일 때 나머지 값을 1,2,3으로 만들 수 있는 방법 더해줌
                }

                sb.append(dp[num]).append("\n");
            }
        }
        System.out.println(sb);
    }
}
/*
 * 같은 것이 있는 순열
 * 1 * 7 -> 1
 * 
 * 1과 2 조합
 * 1 * 5 / 2 * (7 - 5) -> 6
 * 1 * 3 / 2 * 2 -> 10
 * 1 * 1 / 2 * 3 -> 4
 * 
 * 1과 3 조합
 * 1 * 4 / 3 * 1 -> 5
 * 1 * 1 / 3 * 2 -> 3
 * 
 * 1,2,3 조합
 * 1 * 2 / 2 * 1 / 3 * 1 -> 12
 * 2 * 2 / 3 * 1 -> 3
 * ------------------------------
 * 44
 *    
 * 
 * 
 * 0 -> 1   : 0을 만들 수 있는 개수
 * 1 -> 1   : 1을 만들 수 있는 개수
 * ------
 * 2 -> 2   : 2를 만들 수 있는 개수 
 * 3 -> 4   : 2를 만들 수 있는 개수 + 1을 만들 수 있는 개수 + 0을 만들 수 있는 개수  
 * 4 -> 7   : 3을 만들 수 있는 개수 + 2를 만들 수 있는 개수 + 1을 만들 수 있는 개수
 * 5 -> 13
 * 6 -> 24
 * 7 -> 44
 * 8 -> 81
 * 9 -> 149
 * 10 -> 274 .... 확인 완
 */