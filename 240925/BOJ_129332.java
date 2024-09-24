import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class BOJ_129332 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static boolean[] visited;
    static String ducks;
    static String quack = "quack";

    public static void main(String[] args) throws IOException {
        ducks = br.readLine();
        visited = new boolean[ducks.length()];

        int count = 0;

        if(ducks.length()%5!=0){
            System.out.println(-1);
            return;
        }

        for (int i = 0; i < ducks.length(); i++) {
            if (ducks.charAt(i) == 'q' && !visited[i]) {
                int next = 0;
                boolean isDuck = true;

                for (int j = i; j < ducks.length(); j++) {
                    if (ducks.charAt(j) == quack.charAt(next) && !visited[j]) {
                        visited[j] = true;

                        if (ducks.charAt(j) == 'k') {
                            if (isDuck) {
                                count++;
                                isDuck = false;
                            }
                            next = 0;
                        } else {
                            next++;
                        }
                    }
                }
            }
        }

        for (boolean b : visited) {
            if (!b) {
                System.out.print(-1);
                return;
            }
        }

        if (count == 0) {
            System.out.print(-1);
        } else {
            System.out.print(count);
        }
    }
}
