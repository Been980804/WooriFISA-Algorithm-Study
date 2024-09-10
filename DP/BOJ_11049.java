import java.io.*;
import java.util.StringTokenizer;

/*
(5,3)
(3,2)
(2,6)

표 채워가기
(1) (AB)C
    -> 5*3*2 = 30
    -> (5*3*2)*(2*6) -> 5*2*6 = 60
    -> 토탈 : 90
(2) A(BC)
    -> 3*2*6 = 36
    -> (5*3)(3*2*6) => 5*3*6 = 90
    => 토탈 : 126

    min(90,126) => return 90

 */
public class BOJ_11049 {
    static int[][] matrix; // 행렬
    static int[][] dp;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int n,r,c;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        matrix = new int[n][2];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            matrix[i][0] = Integer.parseInt(st.nextToken());
            matrix[i][1] = Integer.parseInt(st.nextToken());
        }
        //bw.write();
        bw.flush();
        bw.close();
        br.close();

    }

    public static void matrixCalculator(){
        // ?
        ;
    }
}
