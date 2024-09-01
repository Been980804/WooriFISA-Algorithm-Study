import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        visited = new boolean[n][n];

        int ans = 1;
        int rain = 0; // 내리는 비의 최대 양

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                rain = Math.max(rain, board[i][j]);
            }
        }
        // System.out.println(Arrays.deepToString(board));

        int cnt; // 안전 구역 갯수

        for (int h = 1; h <= rain; h++) {
            visited = new boolean[n][n];
            cnt = 0;

            // 안전구역이 시작되는 지점 확인해서 해당 지점부터 dfs 탐색 시작
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j] && board[i][j] > h) {
                        cnt++;
                        dfs(i, j, h);
                    }
                }
            }
            // 안전 구역이 더 많은 경우로 갱신
            ans = Math.max(ans, cnt);
        }
        System.out.println(ans);
    }

    public static void dfs(int x, int y, int h) {
        visited[x][y] = true;

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                if (!visited[nx][ny] && board[nx][ny] > h)
                    dfs(nx, ny, h);
            }
        }
    }
}
