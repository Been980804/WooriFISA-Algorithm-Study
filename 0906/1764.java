import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static String[] arrN;
    public static String[] arrM;
    public static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arrN = new String[N];
        arrM = new String[M];

        Set<String> setN = new HashSet<>(); //해시셋
        ArrayList<String> answer = new ArrayList<>();

        // 배열 N 입력받기
        for (int i = 0; i < N; i++) {
            arrN[i] = br.readLine();
            setN.add(arrN[i]); // 배열 N의 요소를 해시셋에 추가
        }

        // 배열 M 입력받기
        for (int i = 0; i < M; i++) {
            arrM[i] = br.readLine();
            if (!setN.add(arrM[i])) { // 배열 M의 요소가 해시셋에 있다면 false (!있으므로 조건 충족)
                answer.add(arrM[i]);
            }
        }

        // 정답 정렬
        Collections.sort(answer);

        // 정답 출력
        System.out.println(answer.size());
        for (String word : answer) {
            System.out.println(word);
        }
    }
}