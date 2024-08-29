import java.io.*;

public class boj_2877 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        String ans = "";

        while (k > 0) {
            boolean isEven = (k % 2 == 0);
            k /= 2;

            if (isEven) {
                ans = "7" + ans;
                k--;
            } else {
                ans = "4" + ans;
            }
        }
        System.out.println(ans);
    }
}

// 1 2  3  4  5  6   7   8   9
// 4 7 44 47 74 77 444 447 474
// 짝수번째에서 일의 자리는 무조건 7, 홀수번째에서는 일의 자리 무조건 4

// 4   7  44   47  74
// 0  10  11  100 101
