import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();

        //////////////////////////////////////////////// 입력 ////////////////////////////////////////////////
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        List<Integer> sortedList = new ArrayList<>(new HashSet<>(list));
        Collections.sort(sortedList);


        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < sortedList.size(); i++) {
            map.put(sortedList.get(i), i);
        }

        StringBuilder sb = new StringBuilder();
        for (int num : list) {
            sb.append(map.get(num)).append(" ");
        }

        System.out.println(sb.toString());
    }
}