package algorithm.hyeonbeen.week5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12933 {
    
    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuffer sb = new StringBuffer();
    public static StringTokenizer st;
    
    public static int[] arr = new int[6];

    public static void main(String[] args) throws Exception {
        String duck = br.readLine();    // 울음소리
        int len = duck.length();
    
        int max = 0;
        arr[0] = len;

        for(int i = 0; i < len; i++){
            int n = 0;
            if(duck.charAt(i) == 'q') n = 1;
            if(duck.charAt(i) == 'u') n = 2;
            if(duck.charAt(i) == 'a') n = 3;
            if(duck.charAt(i) == 'c') n = 4;
            if(duck.charAt(i) == 'k') n = 5;
            if(arr[n-1] == 0){                  // 이전 나왔어야할 문자가 없으면 잘못된 경우 Ex) qauck
                System.out.println(-1);;
                return;
            }
            arr[n]++;                           // 나온 문자에대한 오리 개수 증가
            arr[n-1]--;                         // 문자가 합쳐졌으니 이전 문자는 감소
            max = Math.max(max, arr[1] + arr[2] + arr[3] + arr[4]);  // arr[1]~arr[4] 의 합은 -> 현재 울고있는 오리의 수를 의미 / arr[5]는 이미 울음을 마쳤기 때문
        }

        if(arr[5] * 5 != len){
            System.out.println(-1);;
            return;
        }
        System.out.println(max);
    }
}

/*
 *  https://velog.io/@ssuzyn/%EA%B5%AC%ED%98%84-12933.-%EC%98%A4%EB%A6%AC
 * 
 *  n은 위치를 의미 quack
 *  arr[1] : 'q'를 말한 오리 개수
 *  arr[2] : 'u'를 말한 오리 개수
 *  arr[3] : 'a'를 말한 오리 개수
 *  arr[4] : 'c'를 말한 오리 개수
 *  arr[5] : 'k'를 말한 오리 개수
 */