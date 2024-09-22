import java.io.*;
import java.util.*;

public class Main {
    static int n, m, k, x;  // 도시 개수, 도로 개수, 거리 정보, 출발 도시
    static ArrayList<Integer>[] graph;
    static int[] visited;
    static ArrayList<Integer> ans = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        visited = new int[n + 1];

        for (int i = 0; i <= n; i++)
            graph[i] = new ArrayList<Integer>();

        for (int i = 0; i <= n; i++)
            visited[i] = -1;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
        }

        bfs(x);

        for (int i = 0; i <= n; i++) {
            if (visited[i] == k)
                ans.add(i);
        }

        if (ans.isEmpty())
            System.out.println("-1");
        else {
            Collections.sort(ans);
            for (int i : ans) {
                System.out.println(i);
            }
        }
    }

    public static void bfs(int node) {
        Queue<Integer> q = new LinkedList<>();

        q.add(node);
        visited[node]++;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : graph[cur]) {

                if (visited[next] == -1) {
                    visited[next] = visited[cur] + 1;
                    q.add(next);
                }
            }
        }
    }
}
