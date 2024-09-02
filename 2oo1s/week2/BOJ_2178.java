import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++)
                board[i][j] = str.charAt(j) - '0';
        }
        // System.out.println(Arrays.deepToString(board));

        bfs(0, 0);
      
        System.out.println(board[n - 1][m - 1]);
    }

    public static void bfs(int i, int j) {
        Queue<Integer[]> q = new LinkedList<>();

        visited[i][j] = true;
        q.add(new Integer[]{i, j});

        while (!q.isEmpty()) {
            Integer[] temp = q.poll();
          
            for (int k = 0; k < 4; k++) {
                int nx = temp[0] + dx[k];
                int ny = temp[1] + dy[k];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (!visited[nx][ny] && board[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        board[nx][ny] = board[temp[0]][temp[1]] + 1;
                        q.add(new Integer[]{nx, ny});
                    }
                }
            }
        }
    }
}

// 26분
