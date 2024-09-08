import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ///////////////////////////////////////////// 입력 처리 /////////////////////////////////////////////

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        int budget = Integer.parseInt(br.readLine());


        Collections.sort(list);

        int temp = 0;
        int answer = 0;
        for (int i = 0; i < N; i++) {
//            System.out.println(temp);

            if (temp + list.get(i) * (N - i) > budget) {
                answer = (budget - temp) / (N - i);
                break;
            } else {
                temp += list.get(i);
            }
        }

        if (answer == 0) {
            answer = list.get(N - 1);
        }

        System.out.println(answer);
    }
}