package algorithm.hyeonbeen.week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.util.ArrayList;
import java.util.Collections;

public class BOJ_7795 {
    
    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuffer sb = new StringBuffer();
    public static StringTokenizer st;

    public static int T, N, M, cnt;
    public static ArrayList<Integer> A, B;

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
       
        for (int t = 0; t < T; t++) {
            cnt = 0;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());   // A의 수
            M = Integer.parseInt(st.nextToken());   // B의 수
            
            A = new ArrayList<>();
            st = new StringTokenizer(br.readLine());

            for (int n = 0; n < N; n++) {
                A.add(Integer.parseInt(st.nextToken()));
            }
            
            B = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int m = 0; m < M; m++) {
                B.add(Integer.parseInt(st.nextToken()));
            }

            Collections.sort(B);

            for(int n = 0; n < N; n++){
                int start = 0;
                int end = M-1;

                while(start <= end){
                    int mid = (start + end) / 2;     // 중간 지점
                    if(B.get(mid) < A.get(n)){       // 정렬한 B값의 중앙값이 A에 있는 값들보다 작으면 
                        start = mid + 1;             // mid보다 큰 값쪽으로 이동    // 최종적으로 start 값이(index + 1)이 A에서 각각 먹을 수 있는 수가 됨 
                    } else {                         // mid보다 작은 값 쪽으로 이동
                        end = mid - 1;
                    }
                }
                cnt += start;                         // 각 index별 먹을 수 있는 쌍 개수 
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}
