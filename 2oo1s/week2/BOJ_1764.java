import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] notHeard = new String[n];  // 듣도 못한 사람
        String[] notSeen = new String[m];   // 보도 못한 사람
        HashMap<String, Integer> map = new HashMap<>(); // 각 사람이 몇 번 입력되는 count

        for (int i = 0; i < n; i++) {
            notHeard[i] = br.readLine();
            map.put(notHeard[i], 1);
        }

        /*
        getOrDefault() 사용해서 이미 map에 있는 경우엔, value값에 +1을
        map에 처음 저장되는 경우엔 value값을 1로 지정
         */
        for (int i = 0; i < m; i++) {
            notSeen[i] = br.readLine();
            map.put(notSeen[i], map.getOrDefault(notSeen[i], 0) + 1);
        }
        // System.out.println(map);

        // 사전 순으로 이름 출력을 위한 작업
        List<String> nameSet = new ArrayList<>(map.keySet());
        Collections.sort(nameSet);

        // 듣도 보도 못한 사람 수
        int cnt = (n + m) - map.size();
        sb.append(cnt).append("\n");

        for (String s : nameSet) {
            if (map.get(s) > 1)
                sb.append(s).append("\n");
        }

        System.out.println(sb.toString());
    }
}
