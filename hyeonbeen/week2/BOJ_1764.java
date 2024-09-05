package algorithm.hyeonbeen.week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_1764 {
    
    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuffer sb = new StringBuffer();
    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int cnt = 0;
        HashMap<String, Integer> map = new HashMap<>();
        
        // 듣도 못한 놈
        for (int i = 0; i < N; i++) {
            map.put(br.readLine(), 1);
        }

        // 보도 못한 놈
        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            if (map.containsKey(str)) {
                map.put(str, 2);    // 듣도 보도 못한 놈
            }
        }
        
        ArrayList<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list);

        for(String key : list){
            if(map.get(key) == 2){
                cnt++;
                sb.append(key).append("\n");
            }
        }

        System.out.println(cnt + "\n" +sb);
    }
}
