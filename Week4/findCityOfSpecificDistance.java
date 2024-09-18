package Week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// 노드 X부터 다른 모든 노드까지의 최소거리 구하고 그 최소거리 중 M의 값을 가진 노드를 구한 후 정렬하면 될 것 같다.
// 다익스트라 알고리즘 ??
// PriorityQueue 사용할때 비교기준이 있어야한다. 따라서  Comparable 인터페이스를 구현하고 cost를 기준으로 비교하도록 구현한다.
class Node implements Comparable<Node>{
    int nodeNum;
    int cost;

    public Node(int nodeNum, int cost){
        this.nodeNum = nodeNum;
        this.cost = cost;
    }
    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.cost, other.cost); // cost 기준으로 비교
    }

}
public class findCityOfSpecificDistance {
    static ArrayList<Node>[] graph;

    public static void Dijkstra(int N, int start, int K){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        ArrayList<Integer> result = new ArrayList<>();

        boolean[] visited = new boolean[N+1];
        int[] dist = new int[N+1];
        int selectNode;

        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[start] = 0;

        pq.offer(new Node(start,0));

        while(!pq.isEmpty()){
            selectNode = pq.poll().nodeNum;
            if(visited[selectNode]) continue;
            visited[selectNode] = true;

            for(Node connNode : graph[selectNode]){
                if(dist[connNode.nodeNum] > dist[selectNode] + connNode.cost){
                    dist[connNode.nodeNum] = dist[selectNode] + connNode.cost;

                    pq.offer(new Node(connNode.nodeNum,dist[connNode.nodeNum]));
                }
            }
        }

        for(int i=1;i<dist.length;i++){
            if(dist[i]==K){
                result.add(i);
            }
        }
        result.sort(Comparator.naturalOrder());
        if(result.isEmpty()){
            System.out.print("-1");
        }
        else{
            for(int i : result) System.out.println(i);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] params = br.readLine().split(" ");
        // 도시 개수 N, 도로 개수 M, 최단거리 K, 출발 도시 번호 X
        int N = Integer.parseInt(params[0]);
        int M = Integer.parseInt(params[1]);
        int K = Integer.parseInt(params[2]);
        int X = Integer.parseInt(params[3]);

        int x,y;
        String[] edges;
        //TODO X에서 K만큼 거리를 가진 도시의 번호를 오름차순으로 출력

        // 그래프 생성
        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++)  graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            edges = br.readLine().split(" ");
            x = Integer.parseInt(edges[0]);
            y = Integer.parseInt(edges[1]);
            graph[x].add(new Node(y,1));
        }
        Dijkstra(N,X,K);
    }
}
