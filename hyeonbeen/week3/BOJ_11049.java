package algorithm.hyeonbeen.week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11049 {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuffer sb = new StringBuffer();
    public static StringTokenizer st;

    public static int[][] arr;
    public static int sum, min;
    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());            // 행렬의 개수

        arr = new int[N][2];

        for(int i = 0 ; i < N; i++){
            st = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken());       // r
            arr[i][1] = Integer.parseInt(st.nextToken());       // c
        }

        min = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++){
            int temp = 0;
            int  mul = 0;

            for(int j = 0; j < N; j++){
                if(i == j) continue;

                mul = arr[i][0] * arr[i][1] * arr[j][1];

                sum = temp + mul;   // 0 + 곱 -> 곱1 + 곱2
                temp = mul;         // 곱2
            }
            min = Math.min(min, sum);
        }

        System.out.println(min);
    }
    
}