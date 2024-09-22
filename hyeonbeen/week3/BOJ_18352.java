package algorithm.hyeonbeen.week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

@SuppressWarnings("unchecked")
public class BOJ_18352 {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuffer sb = new StringBuffer();
    public static StringTokenizer st;

    public static int N, M, K, X;    
    public static List<Integer>[] map;
    public static boolean[] visited;
    public static int[] distance;

    public static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());       //  도시의 수
        M = Integer.parseInt(st.nextToken());       //  도로의 개수
        K = Integer.parseInt(st.nextToken());       //  거리 정보
        X = Integer.parseInt(st.nextToken());       //  출발 도시 번호

        map = new ArrayList[N + 1];

        for(int i = 1; i <= N; i++){
            map[i] = new ArrayList<>();
        }
        visited = new boolean[N+1];
        distance = new int[N+1];
        Arrays.fill(distance, Integer.MAX_VALUE);   // 무한값으로 초기화

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            map[node1].add(node2);                   // node1 에서 node2로 1길이만큼의 도로가 연결되어있음(단방향)
        }

        bfs(X);

        for(int i = 1; i <= N; i++){
            if(distance[i] == K){
                sb.append(i).append("\n");
            }
        }

        if(sb.length() == 0){
            sb.append(-1);
        }

        System.out.println(sb);    
    }

    public static void bfs(int X){
        visited[X] = true;
        q.add(X);
        distance[X] = 0;

        while(!q.isEmpty()){
            int node = q.poll();
            for(int linkedNode : map[node]){
                if(!visited[linkedNode]){
                    visited[linkedNode] = true;
                    distance[linkedNode] = distance[node] + 1;
                    q.add(linkedNode);
                }
            }
        }
    }
}

/*  1 -> 2 -> 3 (이미 방문 처리 되어있음)    길이 2
           -> 4 (출력)
         3

    1 -> 2                                  길이 2
      -> 3
      -> 4

    1 -> 2 -> 3                             길이
           -> 4
      -> 3
*/

/*  이코테 참고

메모리 초과 -> 시간복잡도 O(V^2)

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuffer sb = new StringBuffer();
    public static StringTokenizer st;

    public static int N, M, K, X;
    public static int[][] map;
    public static boolean[] visited;
    public static Queue<Integer> queue = new LinkedList<>();

    public static int[] distance;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());       //  도시의 수
        M = Integer.parseInt(st.nextToken());       //  도로의 개수
        K = Integer.parseInt(st.nextToken());       //  거리 정보
        X = Integer.parseInt(st.nextToken());       //  출발 도시 번호

        map = new int [N+1][N+1];
        visited = new boolean[N+1];
        distance = new int[N+1];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            map[node1][node2] = 1;                  // node1 에서 node2로 1길이만큼의 도로가 연결되어있음(단방향)
        }

        bfs(X);
        
        for(int i = 1; i <= N; i++){
            if(distance[i] == K){
                sb.append(i).append("\n");
            }
        }

        if(sb.length() == 0){
            sb.append(-1);
        }

        System.out.println(sb);        
    }

    public static void bfs(int X){
        visited[X] = true;
        queue.add(X);
        
        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int i = 1; i <= N; i++){
                if(map[node][i] == 1 && !visited[i]){
                    queue.add(i);
                    visited[i] = true;
                    distance[i] = distance[node] + 1;
                }
            }
        }
    }
}
    -> 인접 리스트로 변경
 */
