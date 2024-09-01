import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int[][] arr;
    private static boolean[][] visited;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        visited = new boolean[N][N];

        //////////////////////////////////////////////// 입력 ////////////////////////////////////////////////
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;

        for (int h = 0; h < 100; h++) {
            // 최댓값 구하기
            answer = Math.max(answer, solve(h));
        }

        System.out.println(answer);
    }

    private static void bfs(int si, int sj, int h) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{si, sj});
        visited[si][sj] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int ci = current[0];
            int cj = current[1];

            // 4방향 탐색
            for (int d = 0; d < 4; d++) {
                int ni = ci + dx[d];
                int nj = cj + dy[d];

                if (0 <= ni && ni < N && 0 <= nj && nj < N && !visited[ni][nj] && arr[ni][nj] > h) {
                    queue.add(new int[]{ni, nj});
                    visited[ni][nj] = true;
                }
            }
        }
    }

    private static int solve(int h) {
        int count = 0;

        // 방문 배열 초기화
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                visited[i][j] = false;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && arr[i][j] > h) {
                    bfs(i, j, h);
                    count++;
                }
            }
        }

        return count;
    }
}