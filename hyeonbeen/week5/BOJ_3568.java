package algorithm.hyeonbeen.week5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3568 {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuffer sb = new StringBuffer();
    public static StringTokenizer st;

    public static StringBuffer sb2;
    public static String alp, sym, str, common, var;

    public static StringBuffer rev;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine(), " ");
        common = st.nextToken();

        while (st.hasMoreTokens()) {
            str = st.nextToken();

            alp = str.replaceAll("[^a-zA-Z]", "");
            sym = str.replaceAll("[a-zA-Z^;,]", "");

            rev = new StringBuffer();
            for (int i = sym.length() - 1; i >= 0; i--) {
                if (sym.charAt(i) == ']') {
                    rev.append("[]");
                    i--;
                } else {
                    rev.append(sym.charAt(i));
                }
            }

            sb.append(common + rev + " " + alp + ";").append("\n");
        }
        System.out.println(sb);
    }
}

/*
    

 */