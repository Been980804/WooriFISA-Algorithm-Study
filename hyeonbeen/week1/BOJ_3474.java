package algorithm.hyeonbeen.week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_3474 {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            int cnt = 0; // 0의 개수(즉 10의 배수 = 2*5 -> 2의개수 > 5의 배수 => 5의 배수의 개수) 저장할 변수

            int five = 5; // 5의 배수

            while (num / five > 0) { // 더이상 안나눠 떨어지면 종료
                cnt += num / five; // 5^n 으로 나눠줌
                five *= 5; // 5*5로 수정 -> 5*5*5 -> ...
            }

            sb.append(cnt + "\n");
        }

        System.out.println(sb);
    }
}
/* 
0의 개수 -> 10 -> 2* 5

5
10
15
20
25
30
35
40
45
50
55
60

-> 12개 (why? 14개) -> 25와 50에 5가 2개씩 들어있음...............
즉 5^n 개수 구하기
*/