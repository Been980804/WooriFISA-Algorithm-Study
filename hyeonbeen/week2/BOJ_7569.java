package algorithm.hyeonbeen.week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7569 {
    
    static class Tomato{                    // 토마토 class
        int m;
        int n;
        int h;
    
        public Tomato(int h, int m, int n){
            this.h = h;
            this.m = m;
            this.n = n;
        }
    }

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuffer sb = new StringBuffer();

    public static int N, M, H;  
    public static int[][][] box;
    
    // 상 하 좌 우 위 아래
    public static int[] dx = {0,0,-1,1,0,0};
    public static int[] dy = {-1,1,0,0,0,0};
    public static int[] dh = {0,0,0,0,-1,1};

    public static Queue<Tomato> queue = new LinkedList<>();
    public static int min = 0;
    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());   // 상자의 세로 칸
        M = Integer.parseInt(st.nextToken());   // 상자의 가로 칸
        H = Integer.parseInt(st.nextToken());   // 상자의 수
        
        box = new int[H][M][N];
        
        for(int i = 0; i < H; i++){
            for(int j = 0; j < M; j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < N; k++){
                    box[i][j][k] = Integer.parseInt(st.nextToken()); 
                    if(box[i][j][k] == 1){
                        queue.add(new Tomato(i,j,k));
                    }
                }
            }
        }

        System.out.println(bfs());
    }

    public static int bfs(){
        while(!queue.isEmpty()){
            Tomato tomato = queue.poll();

            for(int i = 0; i < 6; i++){
                int nowM = tomato.m + dx[i];
                int nowN = tomato.n + dy[i];
                int nowH = tomato.h + dh[i];

                if(nowM >= 0 && nowM < M && nowN >= 0 && nowN < N && nowH >= 0 && nowH < H){
                    if(box[nowH][nowM][nowN] == 0){
                        queue.add(new Tomato(nowH,nowM,nowN));
                        box[nowH][nowM][nowN] = box[tomato.h][tomato.m][tomato.n] + 1;
                    }
                }
            }            
        }

        for(int i = 0; i < H; i++){
            for(int j = 0; j < M; j++){
                for(int k = 0; k < N; k++){
                    if(box[i][j][k] == 0){  // 즉 막혀있는 부분이 있어 토마토가 익지 않았음
                        return -1;
                    }
                    min = Math.max(min, box[i][j][k]);
                }
            }
        }

        if(min == 1){
            return 0;
        }
        else{
            return min - 1;     // 1부터 시작했으므로(이미 익어있는 토마토로 부터 퍼져나감)
        }
    }
}


/*
 * BFS : Queue (~~ 최소 구할 때 사용)
 * 22:00 ~
 * 토마토 객체 만들어서 좌표 저장해서 활용해보기
 */
