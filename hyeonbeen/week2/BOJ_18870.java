package algorithm.hyeonbeen.week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_18870 {
    
    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuffer sb = new StringBuffer();
    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        int[] x = new int[N]; 

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(st.nextToken());
            x[i] = num;
            set.add(num);
        }
   
        ArrayList<Integer> list = new ArrayList<>(set);
        Collections.sort(list);

        //Collections.binarySearch -> list에서 x[i] 값이 위치한 index값 반환
        // O(N log M)
        for(int i = 0; i < N; i++){
            int idx = Collections.binarySearch(list, x[i]);
            sb.append(idx + " ");
        }

        // for(int i = 0; i < N; i++){
        //     int num = x[i];

        //     int idx = list.indexOf(num);
        //     sb.append(idx + " ");    
        // }
        // chatGPT 검색 결과 시간 복잡도 O(N * M)
        System.out.println(sb);
    }
}
