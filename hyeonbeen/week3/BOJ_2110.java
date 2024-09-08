package algorithm.hyeonbeen.week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.util.Arrays;

public class BOJ_2110 {
    
    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuffer sb = new StringBuffer();
    public static StringTokenizer st;

    public static int N, C, ans, min, max;
    public static int[] x;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 집의 개수
        C = Integer.parseInt(st.nextToken()); // 공유기의 개수

        x = new int[N];
        for (int i = 0; i < N; i++) {
            x[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(x);

        min = 1;                // 최소거리
        max = x[N-1] - x[0];    // 최대거리
        ans = 0;
        while(min <= max){
            int mid = (max + min) / 2;
        
        }
    }
}
