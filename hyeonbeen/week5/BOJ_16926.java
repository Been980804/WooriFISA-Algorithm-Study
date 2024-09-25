package algorithm.hyeonbeen.week5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16926 {
    
    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuffer sb = new StringBuffer();
    public static StringTokenizer st;
    
    public static int N,M,R;
    public static int[][] arr;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());   // N
        M = Integer.parseInt(st.nextToken());   // M
        R = Integer.parseInt(st.nextToken());   // 회전 수

        arr = new int[N][M];

        for(int i = 0; i < N; i++){
            st= new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        func();

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                sb.append(arr[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void func(){
        int cnt = Math.min(N,M) / 2;

        for(int i = 0; i < R; i++){
            for(int j = 0; j < cnt; j++){
                // int 
            }
        }
    }
}

/*
    0 0 <- 0 1 <- 0 2 <- 0 3 <- 0 4
     ↓                           ↑
    1 0    1 1 <- 1 2 <- 1 3    1 4
     ↓      ↓             ↑      ↑
    2 0    2 1 -> 2 2 -> 2 3    2 4
     ↓                           ↑
    3 0 -> 3 1 -> 3 2 -> 3 3 -> 3 4

    
    N : 4 / M : 4 / R : 7

    

 */