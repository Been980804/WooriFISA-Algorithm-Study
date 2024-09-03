package algorithm.hyeonbeen.week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2606 {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuffer sb = new StringBuffer();
    public static StringTokenizer st;

    public static boolean[] visited;
    public static int[][] link;

    public static int N, M, cnt;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine()); // 컴퓨터 수
        M = Integer.parseInt(br.readLine()); // 연결된 컴퓨터 쌍 수
        cnt = 0; // 감염된 컴퓨터 수

        link = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            link[node1][node2] = link[node2][node1] = 1; // 연결된 node들 1로 설정
        }

        System.out.println(dfs(1));
    }

    public static int dfs(int num) {
        visited[num] = true; // 방문노드 처리

        for (int i = 1; i <= N; i++) {
            if (link[num][i] == 1 && !visited[i]) {
                dfs(i);
                cnt++;
            }
        }
        return cnt;
    }

}

/*
 *     | 1   2   3   4   5   6   7
 * ---------------------------------
 *  1  | 0   1   0   0   1   0   0
 *     |
 *  2  | 1   0   1   0   1   0   0
 *     | 
 *  3  | 0   1   0   0   0   0   0
 *     |
 *  4  | 0   0   0   0   0   0   1
 *     |
 *  5  | 1   1   0   0   0   1   0
 *     |
 *  6  | 0   0   0   0   1   0   0
 *     |
 *  7  | 0   0   0   1   0   0   0
 * 
 *  1-2 cnt++ -> 1
 *  2-3 cnt++ -> 2
 *  2-5 cnt++ -> 3
 *  5-6 cnt++ -> 4
 */