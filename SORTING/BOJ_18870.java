import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
5
2 4 -10 4 -9
(1) 작은 순으로 정렬
-10 -9 2 4 4 -> hashmap에 <정렬된 숫자, 랭크> 기록
(2) 0번 부터 시작
0 1 2 3 3
-> 입력 받은 배열대로 출력 ㄴㄴ

랭크 매긴다고 생각

 */

public class BOJ_18870 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int arr[]; // 원본 배열
    static int sortedArr[]; // 정렬된 배열
    static HashMap<Integer,Integer> mp = new HashMap<>(); // 원본 값, 순서
    static int N;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        arr = new int[N];
        sortedArr = new int[N];

        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sortedArr[i] = arr[i];
        }
        Arrays.sort(sortedArr);

        int rank = 0;

        for(int v:sortedArr){
            if(!mp.containsKey(v)){
                mp.put(v,rank);
                rank++;
            }
        }

        for(int i=0;i<N;i++){
            bw.write(mp.get(arr[i])+" ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
