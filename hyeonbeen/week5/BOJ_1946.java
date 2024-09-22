package algorithm.hyeonbeen.week5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1946 {
    
    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuffer sb = new StringBuffer();
    public static StringTokenizer st;
 
    public static int T, N, ans;
    public static int [][] score;

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());        // 테스트 케이스 개수
        
        for(int i = 0; i < T; i++){
            N = Integer.parseInt(br.readLine());    // 지원자 수

            score = new int[N][2];

            for(int j = 0; j < N; j++){
                    st = new StringTokenizer(br.readLine());
                    score[j][0] = Integer.parseInt(st.nextToken());     // 서류 순위
                    score[j][1] = Integer.parseInt(st.nextToken());     // 면접 순위
            }

            Arrays.sort(score, (a,b) -> Integer.compare(a[0], b[0]));

            ans = 0;
            for (int j = N-1; j >= 0; j--) {
                for(int k = j-1; k >=0; k--){
                    if(score[j][1] > score[k][1]){
                        ans++;
                        break;
                    }
                }
            }
            System.out.println(N - ans);
        }
    }
}

/*  

 */