import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
모든 경우의 수를 찾아서 가장 큰 값을 찾기 -> 백트래킹으로 했는데 안 됨 (시간초과)

두 번의 DFS를 수행
1. 임의의 노드에서 시작해서 가장 먼 노드 찾기
2. 첫번째 DFS에서 찾은 가장 먼 노드에서 시작,
그 노드에서 가장 먼 노드를 찾기
=> 시간 복잡도 O(N)

 */
class Nodes{
    int node,cost;
    public Nodes(int node, int cost){
        this.node = node;
        this.cost = cost;
    }
}
public class tree {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int v;
    static boolean visited[];
    static List<List<Nodes>> tree;
    static int farthest;
    static int ans = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        v = Integer.parseInt(br.readLine());
        tree = new ArrayList<>();

        for(int i=0;i<=v;i++){
            tree.add(new ArrayList<>());
        }
        for(int i=0;i<v;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());

            while(true){
                int n = Integer.parseInt(st.nextToken());
                if(n==-1) break;
                int c = Integer.parseInt(st.nextToken());
                tree.get(s).add(new Nodes(n,c));
            }
        }

        // 첫번째 DFS
        visited = new boolean[v+1];
        dfs(1,0);

        // 두번째 DFS
        visited = new boolean[v+1];
        dfs(farthest,0);

        bw.write(String.valueOf(ans));
        bw.flush();
        br.close();
        bw.close();
    }

    public static void dfs(int cur, int distance){
        // 현재까지의 최대 거리 갱신
        /*
        dfs(1,0) 이 호출되고
        1 3 2 -1을 예시로 들면
        
        0은 Integer.MIN_VALUE 보다 크니까
        ans = 0;
        farthest = 1
        
        visited[1] = true;
        1과 연결된 노드 : 3
        
        3은 아직 방문 전,
        dfs(3, 0+2) 로 호출
        여기서 똑같이 확인하면 됨
        
        2는 현재 저장된 0 보다 크니까
        ans는 2가 되고, farthest는 3이 되는 것

        이런식으로 연결된 노드들을 모두 확인하고
        가장 먼 노드를 찾고, 그 값으로부터 최댓값 찾으면 됨 !
         */
        if(distance>ans){
            ans = distance;
            farthest = cur;
        }
        visited[cur] = true;
        for(Nodes n : tree.get(cur)){
            if(!visited[n.node]){
                dfs(n.node,distance+n.cost);
            }
        }
    }
    
    /*
    백트래킹 코드
        visited[cur] = true;
        ans = distance;

        for(Nodes n : tree.get(cur)){
            if(!visited[n.node]){
                ans = Math.max(ans,dfs(n.node,distance+n.cost));
            }
        }
        visited[cur] = false;
        return ans;
     */
}
