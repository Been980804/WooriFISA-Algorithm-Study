import java.io.*;

// 점화식 : dp[i] = dp[i-1]+dp[i-2]+dp[i-3]
/*
n = 1 : 1
n = 2 : 2
n = 3 : 4
n = 4 : 7
n = 5 : 13

 */
public class BOJ_9095 {
    static int[] values;
    static int t;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        t = Integer.parseInt(br.readLine());
        values = new int[12];
        values[0] = 0;
        values[1] = 1;
        values[2] = 2;
        values[3] = 4;


        for(int i=4;i<=11;i++){
            values[i] = values[i-1] + values[i-2]+values[i-3];
        }

        for(int i=0;i<t;i++){
            int num = Integer.parseInt(br.readLine());
            System.out.println(values[num]);
        }
        br.close();
    }
}
