import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2110 {
    static int n,c;
    static int[] arr;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());

            Arrays.sort(arr);

            // 최소 거리 1
            int s = 1;
            // 집들 사이의 최대 거리
            int e = arr[n - 1] - arr[0];
            // 최대 최소 거리를 저장할 변수
            int res = 0;

            while (s <= e) {
                int mid = (s + e) / 2;
                int left = arr[0];
                // 첫번째 집에 공유기 설치
                int cnt = 1;

                for (int j = 1; j < n; j++) {
                    // 배열을 순회하면서 각 집의 위치와 마지막으로 설치된 집의 위치 사이의 거리가 mid 이상일 경우
                    if (arr[j] - left >= mid) {
                        // 새로운 공유기 설치
                        cnt++;
                        // left 현재 집으로 업데이트
                        left = arr[j];
                    }
                }
                // 현재 거리 mid는 가능한 거리
                if (cnt >= c) {
                    res = mid;
                    // 더 큰 거리 탐색
                    s = mid + 1;
                } else {
                    // 거리가 너무 큼 -> 더 작은 거리 탐색
                    e = mid - 1;
                }
            }
            bw.write(String.valueOf(res));
            bw.flush();
            bw.close();
            br.close();
        }
    }
}
