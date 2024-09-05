//package Week2;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.StringTokenizer;
//
//public class treeDiameter {
//    static int v;
//    static ArrayList<Node>[] graph;
//    static boolean[] visited;
//    static int x;
//    static int answer = 0;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//
//        v = Integer.parseInt(br.readLine());
//        graph = new ArrayList[v + 1];
//        visited = new boolean[v + 1];
//
//        for (int i = 0; i <= v; i++)
//            graph[i] = new ArrayList<>();
//
//        for (int i = 0; i < v; i++) {
//            st = new StringTokenizer(br.readLine(), " ");
//            int s = Integer.parseInt(st.nextToken());
//            while (true) {
//                int e = Integer.parseInt(st.nextToken());
//                if (e == -1)
//                    break;
//                int dist = Integer.parseInt(st.nextToken());
//                graph[s].add(new Node(e, dist));
//                graph[e].add(new Node(s, dist));
//            }
//        }
//        dfs(1, 0);
//
//        visited = new boolean[v + 1];
//        dfs(x, 0);
//
//        System.out.println(answer);
//    }
//
//    static public void dfs(int v, int len) {
//        if (len > answer) {
//            answer = len;
//            x = v;
//        }
//        visited[v] = true;
//        for (Node n : graph[v]) {
//            if (!visited[n.vertex]) {
//                visited[n.vertex] = true;
//                dfs(n.vertex, len + n.dist);
//            }
//        }
//    }
//
//    static class Node {
//        int vertex;
//        int dist;
//
//        public Node(int vertex, int dist) {
//            this.vertex = vertex;
//            this.dist = dist;
//        }
//    }
//}