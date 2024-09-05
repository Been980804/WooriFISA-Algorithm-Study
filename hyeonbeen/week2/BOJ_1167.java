package algorithm.hyeonbeen.week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1167 {
    
    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuffer sb = new StringBuffer();
    public static StringTokenizer st;

    public static int[][] link;
    public static boolean[] visited;
    public static int V, ans;
    public static int[] maxDistance;

    public static void main(String[] args) throws Exception {
        V = Integer.parseInt(br.readLine());    // 트리 정점의 개수

        link = new int[V+1][V+1];
        visited = new boolean[V+1];

        for(int i = 1; i <= V; i++){
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());

            while(st.hasMoreTokens()){
                String token = st.nextToken();
                if(token.equals("-1")) break;

                int node2 = Integer.parseInt(token);

                if(st.hasMoreTokens()){
                    int distance = Integer.parseInt(st.nextToken());
                    link[node1][node2] = distance;
                }
            }
        }
        ans = 0;
        maxDistance = new int[V+1];
        System.out.println(dfs(1, maxDistance));

    }

    public static int dfs(int node, int[] maxDistance){
        visited[node] = true;

        for(int i = 1; i <= V; i++){
            if(link[node][i] != 0 && !visited[i]){
                maxDistance[node] = Math.max(maxDistance[node], maxDistance[node] + link[node][i]);
                
                dfs(i, maxDistance);
            }
        }
        
        for(int i = 1; i <= V; i++){
            ans = Math.max(ans, maxDistance[i]);
        }

        return ans;
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