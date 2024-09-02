import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
    int x, y;
    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class maze {
    static Queue<Node> que = new LinkedList<Node>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int n,m;
    static int maze[][];
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};
    static boolean visited[][];

    public static void bfs(int x, int y){
        que.add(new Node(x, y));
        while(!que.isEmpty()){
            Node cur = que.poll();
            int nowX = cur.x;
            int nowY = cur.y;
            for(int i=0;i<4;i++){
                int nx = nowX+dx[i];
                int ny = nowY+dy[i];
                if((nx >= 0 && nx < n) && (ny >= 0 && ny < m) && maze[nx][ny]==1 && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    maze[nx][ny]+= maze[nowX][nowY];
                    que.add(new Node(nx,ny));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        maze = new int[102][102];

        for(int i=0;i<n;i++){
            String inline = br.readLine();
            for(int j=0;j<m;j++){
                maze[i][j] = inline.charAt(j)-'0';
            }
        }
        visited = new boolean[102][102];
        bfs(0,0);

        System.out.println(maze[n-1][m-1]);
    }
}
