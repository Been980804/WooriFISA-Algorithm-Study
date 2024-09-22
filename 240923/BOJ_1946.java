import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*
서류 등수를 기준으로 정렬
서류 2등부터 면접 등수만 가지고 다른 지원자랑 비교

1등의 면접 등수 = 최소
2등의 면접 등수가 최소 면접 등수보다 작다면 합격
최소 면접 등수 => 2등의 면접 등수로 갱신
 */


class new_emp implements Comparable<new_emp> {
    int doc;
    int interview;

    new_emp(int doc, int interview) {
        this.doc = doc;
        this.interview = interview;
    }

    @Override
    public int compareTo(new_emp o) {
        return Integer.compare(this.doc, o.doc);
    }
}

public class BOJ_1946 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int t, n;

    public static void main(String[] args) throws IOException {
        t = Integer.parseInt(br.readLine());

        for (int tc= 0; tc < t; tc++) {
            n = Integer.parseInt(br.readLine());
            ArrayList<new_emp> arr = new ArrayList<>();

            // 각 지원자의 서류와 면접 등수 입력 받기
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arr.add(new new_emp(a, b));
            }

            // 서류 등수로 정렬
            Collections.sort(arr);

            int ans = 1; // 첫 번째 지원자는 무조건 합격
            int min = arr.get(0).interview; // 첫 번째 지원자의 면접 등수를 최소로 설정

            // 2번째 지원자부터 면접 등수를 비교하며 최소값 갱신
            for (int i = 1; i < n; i++) {
                if (arr.get(i).interview < min) {
                    ans++;
                    min = arr.get(i).interview;
                }
            }
            System.out.println(ans);
        }
    }
}
