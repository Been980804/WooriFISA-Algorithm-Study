import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
1 = 익은 토마토
0 = 익지 않은 토마토
-1 = 들어있지 않은 토마토

저장될 때 부터 모든 토마토가 익어있는 상태 = 0 출력
토마토가 모두 익지 못하는 상황 = -1 출력
 */

// 좌표들을 하나의 객체로 만들어서 관리할 수 있게 하기 위해서
class Tomato {
    int r, c, h;

    public Tomato(int r, int c, int h) {
        this.r = r;
        this.c = c;
        this.h = h;
    }
}

public class tomatos {
    // 6방향을 나타내기 위한 배열
    // 한 행 위, 한 행 아래, 한 열 왼쪽, 한 열 오른쪽, 한 층 아래, 한 층 위
    static int dx[] = {-1, 1, 0, 0, 0, 0};  // 행 이동
    static int dy[] = {0, 0, -1, 1, 0, 0};  // 열 이동
    static int dz[] = {0, 0, 0, 0, -1, 1};  // 높이 이동
    static int m, n, h;
    static int arr[][][];
    static Queue<Tomato> que = new LinkedList<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 최단 거리라고 생각하고 업데이트 하기

    public static int bfs() {
        while (!que.isEmpty()) {
            Tomato t = que.poll();

            int he = t.h;
            int ro = t.r;
            int co = t.c;

            for (int i = 0; i < 6; i++) {
                int nh = he + dz[i];
                int nr = ro + dx[i];
                int nc = co + dy[i];
                // 위치 유효시, 큐에 새로운 토마토 저장
                // 해당 위치의 값을 현재 토마토의 익는 시간 +1 로 설정
                if (check(nh, nr, nc)) {
                    que.add(new Tomato(nr, nc, nh));
                    arr[nh][nr][nc] = arr[he][ro][co] + 1;
                }
            }
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= m; k++) {
                    // 배열에 값이 0인 위치가 있는 것 = 모든 토마토가 익지 않았다는 의미
                    if (arr[i][j][k] == 0) return -1;
                    ans = Math.max(ans, arr[i][j][k]);
                }
            }
        }

        // 이미 모든 토마토가 익어있는 경우
        if (ans == 1) {
            return 0;
        } else {
            // ans는 토마토가 익기 시작한 시간부터 계산
            // 결과에 1 빼야 함
            return (ans - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        arr = new int[h + 1][n + 1][m + 1];

        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 1; k <= m; k++) {
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                    // BFS를 시작하는 노드를 큐에 추가
                    // 익은 토마토의 위치에서 시작
                    if (arr[i][j][k] == 1)
                        que.add(new Tomato(j, k, i));
                }
            }
        }

        System.out.println(bfs());
    }

    private static boolean check(int height, int row, int col) {
        // 주어진 범위 밖인지 검사
        if (height < 1 || height > h || row < 1 || row > n || col < 1 || col > m) return false;
        // 아직 익지 않은 토마토라면 true 반환
        if (arr[height][row][col] == 0) return true;
            // 이미 익어있거나 빈 자리라면 false 반환
        else return false;
    }
}
