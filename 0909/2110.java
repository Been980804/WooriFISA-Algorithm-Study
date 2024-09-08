import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 집의 개수
        int C = Integer.parseInt(st.nextToken()); // 공유기 개수


        ///////////////////////////////////////////// 입력 처리 /////////////////////////////////////////////

        List<Integer> positions = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            positions.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(positions);

        int start = 1;  // 최소 거리
        int end = positions.get(N - 1) - positions.get(0);  // 최대 거리
        int answer = 0;
        while (start <= end) {
            int mid = (start + end) / 2;  
            int count = 1;  
            int prevPosition = positions.get(0);  


            for (int i = 1; i < N; i++) {
                if (positions.get(i) - prevPosition >= mid) {
                    count++;  
                    prevPosition = positions.get(i);  
                }
            }

            if (count >= C) {
                answer = mid; 
                start = mid + 1;  
            } else {
                end = mid - 1;  
            }
        }

        System.out.println(answer);
    }
}