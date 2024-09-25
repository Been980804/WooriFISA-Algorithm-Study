package algorithm.hyeonbeen.week5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

public class BOJ_16506 {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuffer sb = new StringBuffer();
    public static StringTokenizer st;

    public static int N, ans;
    public static List<String> list, clist;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine()); // 반복 횟수

        list = new ArrayList<>();
        list.add("ADD");
        list.add("SUB");
        list.add("MOV");
        list.add("AND");
        list.add("OR");
        list.add("NOT");
        list.add("MULT");
        list.add("LSFTL");
        list.add("LSFTR");
        list.add("ASFTR");
        list.add("RL");
        list.add("RR");

        clist = new ArrayList<>();

        for (String str : list) {
            if (str.equals("NOT")) {
                clist.add(str);
            } else {
                clist.add(str);
                clist.add(str + "C");
            }
        }

        String index = "";
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String opcode = st.nextToken();
            String rD = st.nextToken();
            String rA = st.nextToken();
            String rB = st.nextToken();

            index = binary((clist.indexOf(opcode)), "opcode", opcode); // 0~3
            sb.append(index);

            if (opcode.contains("C"))
                sb.append("10"); // 4~5
            else
                sb.append("00");

            rD = binary(Integer.parseInt(rD), "rD", opcode);
            sb.append(rD);

            rA = binary(Integer.parseInt(rA), "rA", opcode);
            sb.append(rA);

            rB = binary(Integer.parseInt(rB), "rB", opcode);
            sb.append(rB);

            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static String binary(int num, String type, String opcode) {
        String str = "";

        if (type.equals("opcode")) {
            if (num >= 11)
                str = Integer.toBinaryString((num + 1) / 2);
            else
                str = Integer.toBinaryString(num / 2);
            while (str.length() - 4 < 0) {
                str = "0" + str;
            }
        } else if (type.equals("rD")) {
            str = Integer.toBinaryString(num);
            while (str.length() - 3 < 0) {
                str = "0" + str;
            }
        } else if (type.equals("rA")) {
            if (opcode.contains("MOV") || opcode.equals("NOT"))
                str = "000";
            else
                str = Integer.toBinaryString(num);
            while (str.length() - 3 < 0) {
                str = "0" + str;
            }
        } else {
            if (opcode.contains("C")) {
                str = Integer.toBinaryString(num);
                while (str.length() - 4 < 0) {
                    str = "0" + str;
                }
            } else {
                str = Integer.toBinaryString(num);
                while (str.length() - 3 < 0) {
                    str = "0" + str;
                }
                str += "0";
            }
        }
        return str;
    }
}

/*
 * ADD 0 index / 2 를 이진수로
 * ADDC 1
 * SUB 2
 * SUBC 3
 * MOV 4
 * MOVC 5
 * AND 6
 * ANDC 7
 * OR 8
 * ORC 9
 * NOT 10
 * 
 * MULT 11 (index + 1) / 2 를 이진수로
 * MULTC 12
 * LSFTL 13
 * LSFTLC 14
 * LSFTR 15
 * LSFTRC 16
 * ASFTR 17
 * ASFTRC 18
 * RL 19
 * RLC 20
 * RR 21
 * RRC 22
 * 
 */