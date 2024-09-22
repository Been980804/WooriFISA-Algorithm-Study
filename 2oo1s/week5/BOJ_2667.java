import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] board;
    static boolean[][] visited;
    static ArrayList<Integer> list = new ArrayList<>();
    static int cnt;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++)
                board[i][j] = str.charAt(j) - '0';
        }
        // System.out.println(Arrays.deepToString(board));

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1 && !visited[i][j]) {
                    cnt = 0;
                    dfs(i, j);
                    list.add(cnt);
                }
            }
        }
        Collections.sort(list);
        System.out.println(list.size());
        for (int i : list)
            System.out.println(i);
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;
        cnt++;

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                if (board[nx][ny] == 1 && !visited[nx][ny])
                    dfs(nx, ny);
            }
        }
    }
}
