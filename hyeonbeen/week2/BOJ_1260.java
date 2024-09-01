package algorithm.hyeonbeen.week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260 {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuffer sb = new StringBuffer();

    public static int N, M, V;
    public static boolean[] visited;            // 방문 여부
    public static int[][] link;                 // 1 index와 2index가 각각의 노드 의미
    public static Queue<Integer> queue = new LinkedList<>();

     public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());   // 정점 개수
        M = Integer.parseInt(st.nextToken());   // 간선 개수
        V = Integer.parseInt(st.nextToken());   // 시작 정점 번호
    
        link = new int[N+1][N+1];
        visited = new boolean[N+1];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            link[node1][node2] = link[node2][node1] = 1;  // ex) 1 2 입력시 link[1][2] 와 link[2][1]을 연결됬다는 의미로 1 입력(양방향)
        }

        dfs(V);

        sb.append("\n");
        visited =  new boolean[N+1];            // bfs에서 사용을 위한 초기화

        bfs(V);

        System.out.println(sb);
    }

    public static void dfs(int V){
        visited[V] = true;                      // 첫 노드 방문 처리
        sb.append(V).append(" ");           

        for(int i = 1; i <= N; i++){            // node 개수만큼 반복
            if(link[V][i] == 1 && !visited[i]){ // 시작 노드와 i 노드와 연결되었고 방문하지 않았으면
                dfs(i);                         // i 노드로 재귀함수 호출
            }
        }
    }

    public static void bfs(int V){
        visited[V] = true;                      // 첫 노드 방문 처리
        queue.add(V);                           // queue에 저장
        sb.append(V).append(" ");           

        while(!queue.isEmpty()){                // queue가 빌 때까지 반복
            int node = queue.poll();            // 처음에 들어온 값 뽑아 오기
            for(int i = 1; i <= N; i++){        // node 개수만큼 반복
                if(link[node][i] == 1 && !visited[i]){  // node와 i가 연결되어있고 방문하지 않았으면
                    queue.add(i);                       // queue에 추가
                    visited[i] = true;                  // 방문 처리
                    sb.append(i).append(" ");       // 순서대로 출력
                }
            }
        }
    }
}

/*
    https://velog.io/@lifeisbeautiful/Java-%EB%B0%B1%EC%A4%80-1260%EB%B2%88-DFS%EC%99%80-BFS-%EC%9E%90%EB%B0%94
    https://seonjun0906.tistory.com/entry/%EB%B0%B1%EC%A4%80-1260-DFS%EC%99%80-BFS
    참고................
    대략 : 17:40 ~ 19:30
    
 * DFS : Stack or 재귀함수  -> LIFO
 * BFS : Queue (LinkedList) -> FIFO
 * 
 * 작은 수 부터 -> 정렬
 */


 /*
    ex) 
    4 5 1
    1 2
    1 3
    1 4
    2 4
    3 4
    
       | 1   2   3   4
    -------------------
    1  | 0   1   1   1
       |
    2  | 1   0   0   1
       |
    3  | 1   0   0   1
       |
    4  | 1   1   1   0
  
  */