package algorithm.hyeonbeen.week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_20365 {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws Exception{
        int N = Integer.parseInt(br.readLine()); // 문제 개수
        String color = br.readLine(); // 정답,오답

        int cntR = 0;
        int cntB = 0;
        char beforeChar = '\0';             // null로 초기화

        for(int i = 0 ; i < N; i++){
            char c = color.charAt(i);
            if(c != beforeChar){            // 이전 문자랑 비교해서 같으면 칠 할 필요 없음
                if(c == 'B') cntB++;
                else cntR++;
            }
            beforeChar = c;                 // 이전 문자 = 현재 문자 (저장)
        }
        int ans = Math.min(cntB, cntR) + 1; // 전체를 한색으로 한번 칠함

        System.out.println(ans);
    }
}