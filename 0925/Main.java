import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        boolean[] check = new boolean[2501]; // 만족하면 인덱스 true로 변경
        int ans = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            String temp = "";
            boolean valid = false;
            int[] index = new int[5]; // "quack"의 인덱스를 저장

            // 울음소리 찾기
            for (int j = i; j < str.length(); j++) {
                if (!check[j]) {
                    if (str.charAt(j) == 'q' && temp.isEmpty()) { // 'q'이고 temp가 빈 문자열인 경우
                        index[0] = j;
                        temp += 'q'; // temp를 'q'로 변경
                    } else if (str.charAt(j) == 'u' && temp.equals("q")) { // 'u'이고 temp가 'q'인 경우
                        index[1] = j;
                        temp += 'u'; // temp를 'qu'로 변경
                    } else if (str.charAt(j) == 'a' && temp.equals("qu")) { // 'a'이고 temp가 'qu'인 경우
                        index[2] = j;
                        temp += 'a'; // temp를 'qua'로 변경
                    } else if (str.charAt(j) == 'c' && temp.equals("qua")) { // 'c'이고 temp가 'qua'인 경우
                        index[3] = j;
                        temp += 'c'; // temp를 'quac'로 변경
                    } else if (str.charAt(j) == 'k' && temp.equals("quac")) { // 'k'이고 temp가 'quac'인 경우
                        index[4] = j;
                        temp += 'k'; // temp를 'quack'로 변경
                    }
                }

                // temp가 "quack"일 때
                if (temp.equals("quack")) {
                    temp = "";
                    if (index[0] < index[1] && index[1] < index[2] && index[2] < index[3] && index[3] < index[4]) {
                        // valid가 false인 경우 true로 바꾸고 ans++
                        if (!valid) {
                            valid = true;
                            ans++;
                        }
                        // quack 인덱스를 true로 처리
                        check[index[0]] = true;
                        check[index[1]] = true;
                        check[index[2]] = true;
                        check[index[3]] = true;
                        check[index[4]] = true;
                    }
                }
            }
        }

        // 인덱스가 false인 것이 있으면 -1 출력
        for (int i = 0; i < str.length(); i++) {
            if (!check[i]) {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(ans);
    }
}
