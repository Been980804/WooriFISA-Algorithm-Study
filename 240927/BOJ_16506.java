import java.io.*;
import java.util.*;

public class BOJ_16506 {
    public static void main(String[] args) throws IOException {
        Map<String, String> opcodes = new HashMap<>(Map.ofEntries(
                Map.entry("ADD", "0000"), Map.entry("SUB", "0001"),
                Map.entry("MOV", "0010"), Map.entry("AND", "0011"),
                Map.entry("OR", "0100"), Map.entry("NOT", "0101"),
                Map.entry("MULT", "0110"), Map.entry("LSFTL", "0111"),
                Map.entry("LSFTR", "1000"), Map.entry("ASFTR", "1001"),
                Map.entry("RL", "1010"), Map.entry("RR", "1011")
        ));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int instructionCount = Integer.parseInt(br.readLine());

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < instructionCount; i++) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            String opcode = tokenizer.nextToken();
            int rD = Integer.parseInt(tokenizer.nextToken());
            int rA = Integer.parseInt(tokenizer.nextToken());
            int rB = Integer.parseInt(tokenizer.nextToken());

            boolean isImmediate = opcode.endsWith("C");
            String baseOpcode;
            if (isImmediate) {
                baseOpcode = opcode.substring(0, opcode.length() - 1);
            } else {
                baseOpcode = opcode;
            }

            result.append(opcodes.get(baseOpcode));
            if (isImmediate) {
                result.append("1");
            } else {
                result.append("0");
            }

            result.append("0");

            result.append(formatBinary(rD, 3));

            if (Arrays.asList("NOT", "MOV", "MOVC").contains(opcode)) {
                result.append("000");
            } else {
                result.append(formatBinary(rA, 3));
            }

            if (isImmediate) {
                result.append(formatBinary(rB, 4));
            } else {
                result.append(formatBinary(rB, 3));
                result.append("0");
            }

            result.append("\n");
        }

        System.out.print(result);
    }

    private static String formatBinary(int number, int bits) {
        String binary = Integer.toBinaryString(number);
        return String.format("%" + bits + "s", binary).replace(' ', '0');
    }
}