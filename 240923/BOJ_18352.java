import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_18352 {
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    static int n, m, k, x;
    static int[] d = new int[300001];  // 최단 거리 저장 배열
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            arr.add(new ArrayList<Integer>());
            d[i] = -1;  // 방문하지 않은 곳은 -1로 초기화
        }

        // 도로 정보 입력
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr.get(a).add(b);  // a번 도시에서 b번 도시로 가는 도로
        }

        // 시작 도시의 최단 거리는 0으로 설정
        d[x] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);

        // BFS 탐색
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i = 0; i < arr.get(now).size(); i++) {
                int next = arr.get(now).get(i);
                if (d[next] == -1) {  // 아직 방문하지 않았다면
                    d[next] = d[now] + 1;  // 최단 거리 갱신
                    q.offer(next);
                }
            }
        }

        // 거리 k인 도시 출력
        boolean check = false;
        for (int i = 1; i <= n; i++) {
            if (d[i] == k) {
                System.out.println(i);
                check = true;
            }
        }

        // 만약 거리가 k인 도시가 없다면 -1 출력
        if (!check) {
            System.out.println(-1);
        }
    }
}
