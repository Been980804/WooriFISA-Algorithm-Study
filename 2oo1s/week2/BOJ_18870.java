import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] sortArr;
        HashMap<Integer, Integer> map = new HashMap<>();

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        sortArr = arr.clone();
        Arrays.sort(sortArr);

        int idx = 0;

        for (int i : sortArr) {
            if (!map.containsKey(i)) {
                map.put(i, idx);
                idx++;
            }
        }

        for (int i : arr)
            sb.append(map.get(i)).append(" ");

        System.out.println(sb.toString());
    }
}
