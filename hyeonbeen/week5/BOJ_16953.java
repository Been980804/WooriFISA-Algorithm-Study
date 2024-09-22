package algorithm.hyeonbeen.week5;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16953 {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuffer sb = new StringBuffer();
    public static StringTokenizer st;

    public static int A,B, ans;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        
        A = Integer.parseInt(st.nextToken()); // A -> B
        B = Integer.parseInt(st.nextToken());
        ans = 1;                           

        while(B > A){
            if(B % 2 == 0){             // B가 짝수
                B /= 2;
            } else if(B % 10 == 1){     // B를 끝자리가 1 일 경우
                //B = Integer.parseInt(Integer.toString(B).replace("1", ""));
                B /= 10;            
            } else{
                break;
            }
            ans++;            
        }

        if(B == A){
            System.out.println(ans);
        } else{
            System.out.println(-1);
        }
    }
}
