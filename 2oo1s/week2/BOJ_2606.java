import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int pair = Integer.parseInt(br.readLine());

        list = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++)
            list[i] = new ArrayList<>();

        for (int i = 0; i < pair; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }
        // System.out.println(Arrays.deepToString(list));

        visited[1] = true;
        dfs(1);
        System.out.println(ans);
    }

    public static void dfs(int v) {
        visited[v] = true;

        for (int i : list[v]) {
            if (!visited[i]) {
                ans += 1;
                visited[i] = true;
                dfs(i);
            }
        }
    }
}
