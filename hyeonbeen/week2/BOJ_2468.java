package algorithm.hyeonbeen.week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2468 {
    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuffer sb = new StringBuffer();

    public static int N;
    public static int[][] map; // 배열 map 저장
    public static boolean[][] visited; // 방문여부 저장

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine()); // N * N 배열

        map = new int[N][N];

        int maxHeight = 0;
        int safezonMax = 0; // 최대 안전영역 수

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, map[i][j]);
            }
        }

        for (int i = 0; i <= maxHeight; i++) { // 높이별로 반복
            int safezonCnt = 0; // 안전영역 수
            visited = new boolean[N][N];

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (map[j][k] > i && !visited[j][k]) {
                        dfs(j, k, i);
                        safezonCnt++;
                    }
                }
            }

            safezonMax = Math.max(safezonMax, safezonCnt);
        }

        System.out.println(safezonMax);
    }

    public static void dfs(int x, int y, int h) {
        if (x < 0 || x >= N || y < 0 || y >= N)
            return; // map 밖으로 나갈시 return (0 ~ N-1)
        if (map[x][y] <= h || visited[x][y])
            return; // 물에 잠겼거나 방문했을 시 return

        visited[x][y] = true;

        dfs(x - 1, y, h); // 상
        dfs(x + 1, y, h); // 하
        dfs(x, y - 1, h); // 좌
        dfs(x, y + 1, h); // 우
    }
}
/*
 * 안전한 영역의 최대 개수
 * DFS : 재귀함수로 근접한 노드들 탐색
 * 
 * 이코테 pg.149 음료수 얼려먹기 참고
 *  대략 : 19:40 ~ 22:00
 */