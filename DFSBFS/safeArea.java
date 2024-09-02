import java.io.*;
import java.util.StringTokenizer;

public class safeArea {
    /*
    (1) 2차원 배열
    (2) 1부터 max까지 돌면서 count
     */

    static int n; // 가로 세로
    static int[][] area;
    static boolean[][] visited;
    // 상 하 좌 우
    // dx 수평 방향
    // dy 수직 방향
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static StringTokenizer st;
    static int count;
    static int ans = 1; // 아무곳도 물에 안잠길때
    static int mx;

    // dfs 깊이 우선 탐색
    // 임의의 한 노드에서 시작해서 다음 분기로 넘어가기 전에 해당 분기를 완벽하게 탐색
    // 그래서 덩어리 찾기가 쉬울 것 같아서 선택

    public static void dfs(int x, int y, int height){
        visited[x][y] = true;
        for(int i=0;i<4;i++){
            int nx = x +dx[i];
            int ny = y+dy[i];
            // 유효한 이동?
            // nx, ny가 그래프 내에 존재하는 가?
            // 방문한 적이 없고 area[nx][ny]가 height 보다 큰가?
            if ((nx >= 0 && nx < n) && (ny >= 0 && ny < n) && !visited[nx][ny] && area[nx][ny] > height) {
                dfs(nx, ny, height);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        area = new int[n][n];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                area[i][j] = Integer.parseInt(st.nextToken());
                // 가장 높은 area 값 찾기
                mx = Math.max(area[i][j],mx);
            }
        }

        for(int h=1;h<=mx;h++){
            visited = new boolean[n][n];
            count = 0;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    // area[i][j] 값이 h보다 높아서 안전지대 이면서
                    // 방문한 적이 없다면
                    if(area[i][j]>h && !visited[i][j]){
                        // 안전 영역 발견할 때마다 해당 영역의 개수 카운트
                        count++;
                        dfs(i,j,h);
                    }
                }
            }
            // ans에 넣을 값 찾기
            ans = Math.max(ans,count);
        }
        bw.write(ans);
        bw.flush();
        br.close();
        bw.close();
    }
}
