package algorithm.hyeonbeen.week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1167 {
    
    static class Node{           // 연결된 노드와 거리를 담을 객체
        int nextNode;
        int distance;

        public Node(int nextNode, int distance){
            this.nextNode = nextNode;
            this.distance = distance;
        }
    }

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuffer sb = new StringBuffer();
    public static StringTokenizer st;

    public static ArrayList<Node>[] list;
    public static boolean[] visited;
    public static int V, finalNode;
    public static int ans = 0;

    @SuppressWarnings("unchecked")
   public static void main(String[] args) throws Exception {
         V = Integer.parseInt(br.readLine());

         list = new ArrayList[V + 1];
         visited = new boolean[V + 1];

         finalNode = 0;

         for(int i = 1; i <= V; i++){
            list[i] = new ArrayList<>();
         }

         for(int i = 0; i < V; i++){
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());          // 메인 노드
            
            while(st.hasMoreTokens()){
               int nextNode = Integer.parseInt(st.nextToken());   // 메인 노드와 연결된 노드
               
               if(nextNode == -1) break;

               int distance = Integer.parseInt(st.nextToken());   // 두 노드 사이 거리
               list[node].add(new Node(nextNode, distance));
            }
         }

         dfs(1,0);             // 1번 노드부터 가장 거리가 먼 노드 찾고

         visited = new boolean[V + 1];
         dfs(finalNode, 0);         // 가장 먼 노드부터 다시 되돌아 감 / 이유 : 1번노드가 중간 노드일 수 있음

         System.out.println(ans);
    }

    public static void dfs(int node, int distance){
      if(distance > ans){
         ans = distance;
         finalNode = node;
      }

      visited[node] = true;      
      for(Node n : list[node]){
         if(!visited[n.nextNode]){
            dfs(n.nextNode, distance + n.distance);
         }
      }
    }
}

/*
    5
    2 4 4 -1
    3 1 2 4 3 -1
    4 2 4 3 3 5 6 -1
    5 4 6 -1
    1 3 2 -1


       | 1   2   3   4   5
    ----------------------    
    1  | 0   0   2   0   0
       |
    2  | 0   0   0   4   0
       |
    3  | 2   0   0   3   0
       |
    4  | 0   4   3   0   6
       |
    5  | 0   0   0   6   0

    
    각 노드에서 최대 거리를 maxDistance[] 에 저장

    maxDistance에서 또 최대 거리 
 */