package algorithm.hyeonbeen.week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11403 {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuffer sb = new StringBuffer();
    public static StringTokenizer st;

    public static int N;
    public static int[][] map, ans;
    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());        // 정점의 개수

        map = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
      
        for(int i = 0; i < N; i++){             // 거쳐가는 노드
            for(int j = 0; j < N; j++){         // 시작 노드
                for(int k = 0; k < N; k++){     // 끝 노드
                    // 시작 노드 -> 거쳐가는 노드가 연결되어있고, 거쳐가는 노드 -> 끝 노드가 연결되어 있으면 시작 노드 -> 끝 노드는 연결되어있음
                    if(map[j][i] == 1 && map[i][k] == 1){
                        map[j][k] = 1;
                    }
                }
            }
        }
          for(int i = 0; i < N; i++){
            for(int j = 0 ; j < N; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}

/*  https://m.blog.naver.com/PostView.nhn?blogId=ndb796&logNo=221234427842&proxyReferer=https:%2F%2Fwww.google.com%2F
 *  N의 범위가 100으로 매우 한정적 -> 플로이드-워셜이 유리 (거쳐가는 노드)
 *  간선이 연결되어있으면 경로가 있다는 의미
 *  
 * 
 *      0   1   2
 * -------------------
 *  0   0   1   0
 *  1   0   0   1
 *  2   1   0   0
 * 
 *   0 -> 1 -> 2 -> 0 (다 연결되어있음)
 */
