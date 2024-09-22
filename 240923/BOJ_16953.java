import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.AbstractMap.SimpleEntry;

class node{
    long a;
    long b;
    node(long a, long b){
        this.a = a;
        this.b = b;
    }
}
public class BOJ_16953 {
    static long a, b;
    static Queue<node> que = new LinkedList<>();

    public static long bfs(long x) {
        que.add(new node(x,0L)); // {x, 0}을 큐에 삽입
        while (!que.isEmpty()) {
            long xx = que.peek().a;  // 큐의 첫 번째 요소의 첫 번째 값
            long cnt = que.peek().b; // 큐의 첫 번째 요소의 두 번째 값
            que.poll();  // 큐의 첫 번째 요소 제거

            if (xx == b) return cnt + 1; // 값이 b와 같으면 종료
            if (xx * 2 <= b) {
                que.add(new node(xx * 2, cnt + 1)); // xx * 2 추가
            }
            if (xx * 10 + 1 <= b) {
                que.add(new node(xx * 10 + 1, cnt + 1)); // xx * 10 + 1 추가
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        a = Long.parseLong(input[0]);
        b = Long.parseLong(input[1]);

        System.out.println(bfs(a)); // BFS 수행
    }
}
