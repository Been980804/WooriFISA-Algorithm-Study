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
        // 그래프 틀을 생성
        ArrayList<ArrayList<Integer>>graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        // 그래프 인접리스트로 구현 각 노드에 연결된 노드를 삽입, 그래프 구현
        for(int i = 0 ; i < E ; i++){
            String[] str = reader.readLine().split(" ");
            int first = Integer.parseInt(str[0]);
            int last = Integer.parseInt(str[1]);
            graph.get(first).add(last);
            graph.get(last).add(first);
        }
        // 방문체크를 위한 배열, 인덱스가 노드 번호로 사용할 것이므로 V+1만큼 생성
        boolean[] visited = new boolean[V+1];
        bfs_list(1,graph,visited);

        System.out.println(Arrays.toString(visited));



    }
    public static void bfs_list(int v, ArrayList<ArrayList<Integer>> graph, boolean[] visited){
         Queue<Integer> q = new LinkedList<>();
         int n = graph.size()-1;
         q.add(v);
         visited[v] = true;
         while (!q.isEmpty()){
             v = q.poll();
             System.out.println(v + " ");

             for(int node : graph.get(v)){
                 q.add(node);
                 visited[node] = true;
             }
         }
    }

}