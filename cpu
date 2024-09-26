import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        HashMap<String, String> hm = new HashMap<>();
        hm.put("ADD", "0000");
        hm.put("SUB", "0001");
        hm.put("MOV", "0010");
        hm.put("AND", "0011");
        hm.put("OR", "0100");
        hm.put("NOT", "0101");
        hm.put("MULT", "0110");
        hm.put("LSFTL", "0111");
        hm.put("LSFTR", "1000");
        hm.put("ASFTR", "1001");
        hm.put("RL", "1010");
        hm.put("RR", "1011");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String opcode = st.nextToken(); 
            int rD = Integer.parseInt(st.nextToken()); 
            int rA = Integer.parseInt(st.nextToken()); 
            int rB = Integer.parseInt(st.nextToken()); 

            if (opcode.charAt(opcode.length() - 1) == 'C') {
                sb.append(hm.get(opcode.substring(0, opcode.length() - 1))).append("1");

            } else {
                sb.append(hm.get(opcode)).append("0");
            }

            sb.append("0"); 
            
            String binary = Integer.toBinaryString(rD);
            sb.append(append(0, binary, 2));

            if (opcode.equals("NOT") || opcode.equals("MOV") || opcode.equals("MOVC")) {
                sb.append("000");
            } else {
                String binary1 = Integer.toBinaryString(rA);
                sb.append(append(0, binary1, 2));
            }

            String binary2 = Integer.toBinaryString(rB);

            if (opcode.charAt(opcode.length() - 1) == 'C') {
                sb.append(append(0, binary2, 3));
            } else {
                sb.append(append(0, binary2, 2)).append("0");
            }

            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static String append(int depth, String str, int limit) {
        if (depth >= limit || limit < str.length()) {
            return str;
        }
        return append(depth + 1, "0" + str, limit);
    }
}
