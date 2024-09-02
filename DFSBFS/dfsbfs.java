import java.io.*;
import java.util.*;

public class dfsbfs {
    static int n, m, v;
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    public static void dfs(int v, BufferedWriter bw) throws IOException {
        bw.write(v + " ");
        visited[v] = true;

        for (int i : graph.get(v)) {
            if (!visited[i]) {
                dfs(i, bw);
            }
        }
    }

    // 현 노드에서 가장 가까운 노드 먼저 탐색
    // 가능한 모든 경로 탐색 -> 최단 경로
    public static void bfs(int v, BufferedWriter bw) throws IOException {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;

        while (!queue.isEmpty()) {
            int now_node = queue.poll();
            bw.write(now_node + " ");
            for (int i : graph.get(now_node)) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph.get(s).add(e);
            graph.get(e).add(s);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(graph.get(i));
        }

        visited = new boolean[n + 1];
        dfs(v, bw);
        bw.newLine();

        Arrays.fill(visited, false);
        bfs(v, bw);
        bw.newLine();

        bw.flush();
        br.close();
        bw.close();
    }
}

