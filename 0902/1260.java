import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        List<List<Integer>> input = new ArrayList<>();
        List<Integer> answerDFS = new ArrayList<>();
        List<Integer> answerBFS = new ArrayList<>();

        for (int i = 0; i < N + 1; i++) {
            input.add(new ArrayList<>());
        }

        //////////////////////////////////////////////// 입력 ////////////////////////////////////////////////
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            // 양방향
            input.get(u).add(v);
            input.get(v).add(u);
        }
//////////////////////////////////////////////// 입력 ////////////////////////////////////////////////

        boolean[] visitedDFS = new boolean[input.size()];
        for (int i = 1; i <= N; i++) {
            Collections.sort(input.get(i));
        }

        DFS(V, input,visitedDFS, answerDFS);
        BFS(V, input, answerBFS);

        // DFS
        for (int node : answerDFS) {
            System.out.print(node + " ");
        }
        System.out.println();
        // BFS
        for (int node : answerBFS) {
            System.out.print(node + " ");
        }
    }

    public static void DFS(int V, List<List<Integer>> input,boolean[] visitedDFS, List<Integer> answer) {
        //시작점 방문 처리
        answer.add(V);
        visitedDFS[V] = true;

        for (int nextNode : input.get(V)) {
            if (!visitedDFS[nextNode]) {
                DFS(nextNode, input, visitedDFS, answer);
            }
        }
    }

    public static void BFS(int V, List<List<Integer>> input, List<Integer> answer) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[input.size()];

        queue.add(V);
        visited[V] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            answer.add(node);

            for (int nextNode : input.get(node)) {
                if (!visited[nextNode]) {
                    queue.add(nextNode);
                    visited[nextNode] = true;
                }
            }
        }
    }
}