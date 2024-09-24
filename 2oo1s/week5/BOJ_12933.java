import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] sound = br.readLine().toCharArray();
        boolean[] isChecked = new boolean[sound.length];
        char[] quack = {'q', 'u', 'a', 'c', 'k'};
        int ans = 0;

        // 애초에 성립조차 안할 때
        if (sound.length % 5 != 0 || sound[0] != 'q') {
            System.out.println(-1);
            return;
        }

        int pt = 0;

        for (int i = 0; i < sound.length; i++) {
            ArrayList<Character> list = new ArrayList<>();

            for (int j = i; j < sound.length; j++) {
                if (!isChecked[j] && sound[j] == quack[pt]) {
                    isChecked[j] = true;
                    list.add(sound[j]);
                    pt++;

                    if (pt == 5)
                        pt = 0;
                }
            }
            
            if (!list.isEmpty()) {
                if (list.get(list.size() - 1) != 'k') {
                    System.out.println(-1);

                    return;
                }
                ans++;
            }
        }
        System.out.println(ans);
    }
}
