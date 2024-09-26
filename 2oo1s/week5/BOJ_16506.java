import java.io.*;
import java.util.*;

public class Main {

    static HashMap<String, String> map = getMap();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            // 4번 bit가 0일 경우 레지스터 rB를, 1일 경우 상수 #C를 사용
            String op = st.nextToken();
            int rd = Integer.parseInt(st.nextToken());
            int ra = Integer.parseInt(st.nextToken());
            int rb = Integer.parseInt(st.nextToken());


            if (op.charAt(op.length() - 1) == 'C')
                sb.append(map.get(op.substring(0, op.length() - 1))).append("1");
            else
                sb.append(map.get(op)).append("0");
        }
    }

    public static HashMap<String, String> getMap() {
        HashMap<String, String> map = new HashMap<>();
        map.put("ADD", "0000");
        map.put("SUB", "0001");
        map.put("MOV", "0010");
        map.put("AND", "0011");
        map.put("OR", "0100");
        map.put("NOT", "0101");
        map.put("MULT", "0110");
        map.put("LSFTL", "0111");
        map.put("LSFTR", "1000");
        map.put("ASFTR", "1001");
        map.put("RL", "1010");
        map.put("RR", "1011");

        return map;
    }
}
