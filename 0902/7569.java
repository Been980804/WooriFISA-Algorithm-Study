import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[][][] graph = new int[M][N][H];
        Queue<int[]> q = new LinkedList<>();

        // 6방향 이동 (상, 하, 좌, 우, 앞, 뒤)
        int[] dx = {0, 0, -1, 1, 0, 0}; // x 방향
        int[] dy = {0, 0, 0, 0, -1, 1}; // y 방향
        int[] dz = {-1, 1, 0, 0, 0, 0}; // z 방향

        //////////////////////////////////////////////// 입력 ////////////////////////////////////////////////
        for (int k = 0; k < H; k++) { // 깊이
            for (int i = 0; i < M; i++) { // 세로
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) { // 가로
                    graph[i][j][k] = Integer.parseInt(st.nextToken());
                    if (graph[i][j][k] == 1) {
                        q.add(new int[]{i, j, k});
                    }
                }
            }
        }
//////////////////////////////////////////////// 입력 ////////////////////////////////////////////////
        System.out.println(bfs(graph, q, dx, dy, dz, M, N, H));
    }

    public static int bfs(int[][][] graph, Queue<int[]> q, int[] dx, int[] dy, int[] dz, int M, int N, int H) {
        int count = 0;

        while (!q.isEmpty()) { // 큐가 다 빌 때까지 실행
            int[] tmp = q.poll();
            int x = tmp[0];
            int y = tmp[1];
            int z = tmp[2];

            // 6방 탐색
            for (int i = 0; i < 6; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nz = z + dz[i];

                // 그래프 범위 안에 있을 경우
                if (nx >= 0 && ny >= 0 && nz >= 0 && nx < M && ny < N && nz < H) {
                    if (graph[nx][ny][nz] == 0) {
                        q.add(new int[]{nx, ny, nz});
                        graph[nx][ny][nz] = graph[x][y][z] + 1; // 새로 추가된 곳은 원래 있던 수 + 1
                    }
                }
            }
        }

        // 모든 칸을 확인하여 최종 날짜 계산
        for (int k = 0; k < H; k++) {
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (graph[i][j][k] == 0) {
                        return -1;
                    }

                    count = Math.max(count, graph[i][j][k]);
                }
            }
        }
        if (count == 1) {
            return 0;
        } else {
            return count - 1;
        }
    }
}