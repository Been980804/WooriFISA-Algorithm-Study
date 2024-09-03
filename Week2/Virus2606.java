package Week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;


public class Virus2606{

    // vertex 1부터 시작해서 연결리스트로 해결하면 될까?
    //
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // 정점 개수
        int V = Integer.parseInt(reader.readLine());
        // 간선 개수
        int E = Integer.parseInt(reader.readLine());
        // 그래프 틀 생성
        ArrayList<ArrayList<Integer>>graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        boolean[] visited = new boolean[V];

        // 그래프 인접리스트로 구현 각 노드에 연결된 노드를 삽입, 그래프 구현
        for(int i = 0 ; i < E ; i++){
            String[] str = reader.readLine().split(" ");

            int first = Integer.parseInt(str[0]);
            int last = Integer.parseInt(str[1]);

            // get은 index를 파라미터로 갖는데 인덱스는 PC번호-1이므로
            graph.get(first-1).add(last);
            graph.get(last-1).add(first);
        }

        bfs(1, graph, visited);

        int count = 0;
        // 1로부터 감염된 PC의 개수를 구해야 하므로 i=1부터
        for(int i=1;i<visited.length;i++){
            if(visited[i]) count++;
        }
        System.out.println(count);
    }
    public static void bfs(int v, ArrayList<ArrayList<Integer>> graph, boolean[] visited){
        //index가 PC번호-1 이므로 -1을 해주었다.
        Queue<Integer> queue = new LinkedList<>();
        visited[v-1] = true;
        queue.add(v);

        while(!queue.isEmpty()){
            v = queue.poll();

            for (int vertex : graph.get(v-1)){
                if(!visited[vertex-1]){
                    visited[vertex-1] = true;
                    queue.add(vertex);
                }
            }
        }

    }
}
