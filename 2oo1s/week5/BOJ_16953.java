import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int ans = 0;

        while (a != b) {
            if (a > b) {
                ans = -1;
                break;
            }

            if (b % 10 == 1)
                b /= 10;
            else if (b % 2 == 0)
                b /= 2;
            else {
                ans = -1;
                break;
            }
            ans++;
        }
        ans = (ans != -1) ? ans + 1 : ans;

        System.out.println(ans);
    }
}
