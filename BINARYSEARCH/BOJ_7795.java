import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_7795 {
    static int t,n,m;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        t = Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            int[] arr = new int[n];
            int[] arr2 = new int[m];

            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int k=0;k<m;k++){
                arr2[k] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr2);
            bw.write(Integer.toString(binarySearch(arr,arr2))+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static int binarySearch(int []arr, int []arr2){
        int count = 0;
        for(int i=0;i<n;i++){
            int s = 0;
            int e = m-1;
            int idx = 0;

            while(s<=e){
                int mid = (s+e)/2;
                if(arr2[mid]<arr[i]){
                    s = mid+1;
                    idx = mid+1;
                }else{
                    e = mid-1;
                }
            }
            count+=idx;
        }
        return count;
    }
}
