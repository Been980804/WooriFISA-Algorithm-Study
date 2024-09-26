import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(", ");

        String com = str[0].split(" ")[0];  // 기본 변수형
        str[0] = str[0].split(" ")[1];
        str[str.length - 1] = str[str.length - 1].replace(";", "");


        for (String s : str) {
            StringBuilder opt = new StringBuilder();
            String end = "";

            for (int j = 0; j < s.length(); j++) {
                char cur = s.charAt(j);

                if (cur == '*' || cur == '&')
                    opt.append(cur);
                else if (cur == '[')
                    opt.append(']');
                else if (cur == ']')
                    opt.append('[');
                else if (('A' <= cur && cur <= 'Z') || ('a' <= cur && cur <= 'z'))
                    end += cur;
            }
            System.out.println(com + opt.reverse() + " " + end + ";");
        }
    }
}
