package algorithm.hyeonbeen.week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178 {

    static class Load { // 좌표 저장할 class
        int x;
        int y;

        public Load(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuffer sb = new StringBuffer();
    public static StringTokenizer st;

    public static int N, M;
    public static int[][] map;
    public static Queue<Load> queue = new LinkedList<>();

    // 상 하 좌 우
    public static int[] dx = { -1, 1, 0, 0 };
    public static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                int k = str.charAt(j) - '0';
                map[i][j + 1] = k;
            }
        }

        System.out.println(bfs(1, 1));
    }

    public static int bfs(int x, int y) {
        queue.add(new Load(x, y));

        while (!queue.isEmpty()) {
            Load load = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nowX = load.x + dx[i];
                int nowY = load.y + dy[i];

                if (nowX > 0 && nowX <= N && nowY > 0 && nowY <= M) {
                    if (map[nowX][nowY] == 1) {
                        queue.add(new Load(nowX, nowY));
                        map[nowX][nowY] = map[load.x][load.y] + 1;
                    }
                }
            }
        }

        return map[N][M]; // 도착지
    }
}
