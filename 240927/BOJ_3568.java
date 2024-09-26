import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_3568 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String[] data = input.split(" ");
        String type = data[0];

        for (String token : data) {
            if (!token.equals(type)) {
                processToken(type, token);
            }
        }

        System.out.print(sb);
    }

    public static void processToken(String type, String token) {
        StringBuilder symbols = new StringBuilder();
        StringBuilder letters = new StringBuilder();

        for (char ch : token.toCharArray()) {
            if (ch == '*' || ch == '&') {
                symbols.append(ch);
            } else if (ch == '[') {
                symbols.append(']');
            } else if (ch == ']') {
                symbols.append('[');
            } else if (Character.isLetter(ch)) {
                letters.append(ch);
            }
        }

        sb.append(type)
                .append(symbols.reverse().toString())
                .append(" ")
                .append(letters.toString())
                .append(";\n");
    }
}
