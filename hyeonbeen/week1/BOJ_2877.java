package algorithm.hyeonbeen.week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2877 {
    
    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());        // N번째 작은 수
        
        int current = N;
        int length = 1;                                 // 한자리수 
        int cnt = 2;                                    // 숫자 2개

        while(current > cnt){                           // N번째 숫자 자리수 계산
            length++;
            current -= cnt;
            cnt *= 2;
        }                                               // ex) N = 8 -> length = 3, current = 2
      
         current--; // 0을 기준으로 인덱스 변환

         for (int i = 0; i < length; i++) {
             if ((current & (1 << (length - i - 1))) > 0) { // 4와 7을 이진법으로 생각, 특정 자리가 1인지 0인지 판단하는 로직
                 sb.append('7');
             } else {
                 sb.append('4');
             }
         }

        System.out.println(sb);
    }
}

/* 
1 4 
2 7 ->2
3 44 
4 47
5 74
6 77 ->4
7 444     2^자리수 - 1 이 자리수별 가장 작은 수
8 447
9 474
10 477
11 744
12 747
13 774
14 777 -> 8
15 4444 -> 16
16 4447
17 4474
18 4477
19 4744
20 4747

N = 8 -> 447
짝수면 7로 끝 홀수면 4로 끝

한자리 = 2개
두자리 = 4개
세자리 = 8개
2^k

몇자리인지 파악.
a = 2 // 한자리마다 2^k
b = 1 // 한자리
While(8 > a)
b++ //자리수 증가
N  -= a //자리수별 몇번째로 작은지
a *=2 // 자리수별 개수 증가


-> b : 3, N : 2, a : 8 즉 3자리수중 2번째로 작음 


444 ~ 777

100의자리  10의자리  1의자리
    4         4        4
    7         7        7

*/



// 4,7 이라 이진법으로 생각 가능 N/2 -> 자리수 이동 가능