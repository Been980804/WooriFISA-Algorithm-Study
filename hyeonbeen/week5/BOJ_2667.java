package algorithm.hyeonbeen.week5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2667 {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuffer sb = new StringBuffer();
    public static StringTokenizer st;

    public static int N;
    public static int[][] map;
    public static boolean[][] visited;
    public static List<Integer> ans;

    // 상하좌우
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};
    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());        // 지도의 크기

        map = new int[N][N];
        visited = new boolean[N][N];
        ans = new ArrayList<>();

        // 공백이없어 StringTokenizer 사용 불가
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < N; j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }

        // 모든 맵을 돌며 집이 위치하고 방문하지 않은 곳
        for(int i = 0 ; i < N; i++){
            for(int j = 0 ; j < N; j++){
                if(map[i][j] == 1 && !visited[i][j]){   
                    int size = dfs(i, j);               // dfs 탐색방식으로 단지내 집들의 수
                    ans.add(size);                      // list에 저장
                }
            }
        }

        Collections.sort(ans);                          // 정렬
        sb.append(ans.size()).append("\n");         // 단지 수

        for(int i : ans){
            sb.append(i).append("\n");              // 단지내 집들의 수
        }

        System.out.println(sb);
    }

    public static int dfs(int x, int y){
        visited[x][y] = true;
        int cnt = 1;                                    // 집 개수 (첫 위치 집 포함)

        for(int i = 0 ; i < 4; i ++){
            int nowX = x + dx[i];
            int nowY = y + dy[i];

            if(nowX >= 0 && nowX < N && nowY >= 0 && nowY < N){
                if(map[nowX][nowY] == 1 && !visited[nowX][nowY]){
                    cnt += dfs(nowX, nowY);             // 단지 집 개수 더해줌
                }
            }
        }

        return cnt;
    }
}

/*  
    2468 참고


 */
