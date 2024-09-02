import java.io.*;
import java.util.StringTokenizer;

public class virus {
    // 컴퓨터의 수, 직접 연결되어 있는 컴퓨터
    static int n, m;
    static int[][] graph;
    static boolean[] visited;
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer stringTokenizer;
    static int count = 0;

    public static void dfs(int start){
        visited[start]=true;
        for(int i=1;i<=n;i++){
            if(!visited[i]&&graph[start][i]==1){
                count++;
                dfs(i);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(bufferedReader.readLine());
        m = Integer.parseInt(bufferedReader.readLine());

        graph = new int[n+1][n+1];

        for (int i = 0; i < m; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int s = Integer.parseInt(stringTokenizer.nextToken());
            int e = Integer.parseInt(stringTokenizer.nextToken());
            graph[s][e] = graph[e][s] = 1;
        }
        visited = new boolean[n+1];
        dfs(1);

        bufferedWriter.write(String.valueOf(count));
        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }

}