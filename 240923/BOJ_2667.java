import java.io.*;
import java.util.*;

public class BOJ_2667 {
    static int[][] arr;
    static boolean[][] visited;
    static int n;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};
    static int count;
    static List<Integer> result;
    public static void main(String[] args)throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visited = new boolean[n][n];
        count = 1;
        result = new ArrayList<>();
        for(int i=0;i<n;i++){
            String str = br.readLine();
            for(int j=0;j<n;j++){
                arr[i][j] = str.charAt(j) - '0';
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]==1 && !visited[i][j]){
                    DFS(i,j);
                    result.add(count);
                    count = 1;
                }
            }
        }
        Collections.sort(result);
        bw.write(result.size()+"\n");
        for(int i=0;i<result.size();i++){
            bw.write(result.get(i)+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static void DFS(int x,int y){
        visited[x][y] = true;
        for(int k=0;k<4;k++){
            int nx = x +dx[k];
            int ny = y +dy[k];
            if(check(nx,ny)&&!visited[nx][ny]&&arr[nx][ny]==1){
                count++;
                DFS(nx,ny);
            }
        }
    }

    public static boolean check(int nx,int ny){
        return nx >= 0 && ny >= 0 && nx < n && ny < n;
    }
}
