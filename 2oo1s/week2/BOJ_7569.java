import java.io.*;
import java.util.*;

public class Main {
    static int m, n, h;
    static int[][][] board;
    static int[] dx = {0, -1, 0, 1, 0, 0};
    static int[] dy = {1, 0, -1, 0, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static Queue<Tomato> q = new LinkedList<>();
    static int ans = 0;

    public static class Tomato {
        int z, y, x;

        public Tomato(int z, int y, int x) {
            this.z = z;
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        m = Integer.parseInt(st.nextToken());   // 열
        n = Integer.parseInt(st.nextToken());   // 행
        h = Integer.parseInt(st.nextToken());

        board = new int[h][n][m];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int k = 0; k < m; k++) {
                    board[i][j][k] = Integer.parseInt(st.nextToken());
                    if (board[i][j][k] == 1)
                        q.add(new Tomato(i, j, k));
                }
            }
        }
        // System.out.println(Arrays.deepToString(tomato));
        System.out.println(bfs());
    }

    public static int bfs() {
        while (!q.isEmpty()) {
            Tomato t = q.poll();

            for (int k = 0; k < 6; k++) {
                int nz = t.z + dz[k];
                int ny = t.y + dy[k];
                int nx = t.x + dx[k];

                if (nx >= 0 && ny >= 0 && nz >= 0 && nx < m && ny < n && nz < h) {
                    if (board[nz][ny][nx] == 0) {
                        q.add(new Tomato(nz, ny, nx));
                        board[nz][ny][nx] = board[t.z][t.y][t.x] + 1;
                    }
                }
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (board[i][j][k] == 0) {
                        // System.out.println("0 발견");
                        return -1;
                    }
                    ans = Math.max(ans, board[i][j][k]);
                }
            }
        }

        if (ans == 1)
            return 0;
        else
            return ans - 1;
    }
}
