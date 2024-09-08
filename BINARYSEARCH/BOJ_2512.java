import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2512 {
    static int n;
    static int[] arr;
    static int budget;
    static long ans;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        budget = Integer.parseInt(br.readLine());
        bw.write(Long.toString(binarySearch()));
        bw.flush();
        bw.close();
        br.close();
    }

    public static long binarySearch(){
        long s = 0;
        long e = arr[n-1];
        ans = 0;

        while(s<=e){
            // 중간 값 찾기
            long mid = (s+e)/2;
            long money = 0;
            for(int v:arr){
                if(v>=mid){
                    money+=mid;
                }else{
                    money+=v;
                }
            }
            // 현재 금액이 budget을 초과하면, 상한액 줄이기 위해 -1
            if(money>budget){
                e = mid-1;
            // 아니라면 상한액 증가를 위해 +1
            }else{
                s = mid+1;
                // 더 큰 값으로 갱신
                ans = Math.max(ans,mid);
            }
        }
        return ans;
    }
}
