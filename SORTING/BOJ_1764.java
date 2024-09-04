import java.io.*;
import java.util.*;

public class BOJ_1764 {
    static Map<String, Integer> mp = new HashMap<>();
    static Set<String> set = new TreeSet<>();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, m;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            String nm = br.readLine();
            mp.put(nm, mp.getOrDefault(nm, 0) + 1);
        }

        for (int i = 0; i < m; i++) {
            String nm = br.readLine();
            if (mp.getOrDefault(nm, 0) > 0) {
                set.add(nm);
            }
        }

        bw.write(set.size() + "\n");
        for (String str : set) {
            bw.write(str + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
