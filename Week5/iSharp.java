package Week5;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class iSharp {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        // ','랑';' 제거하고 공백을 기준으로 문자열 나눔
        String[] dividedStrings = input.replaceAll(";","").replaceAll(",", "").split(" ");
        ArrayList<String> dividedList = new ArrayList<>();

        for (String s : dividedStrings) {
            dividedList.add(s);
        }
        // 공통 기본형타입
        String commonPrimitiveType = dividedList.get(0);

        String[] result = new String[2];
        // for문에서 공통기본형타입도 함수에 넣게되니 제거
        dividedList.remove(0);

        for(String s : dividedList){
            result = getAdditionalVar(s);
            System.out.println(commonPrimitiveType+result[0]+" "+result[1]+";");
        }

    }

    public static String[] getAdditionalVar(String input){
        ArrayList<String> alphabet = new ArrayList<>();
        ArrayList<String> type = new ArrayList<>();

        String varName;
        String varType;

        String output[] = new String[2];

        for(char c :  input.toCharArray()){
            // 알파벳만 담아서 변수명으로 저장
            if(65<=c&&c<=122&&c!=91&&c!=93){
                alphabet.add(String.valueOf(c));
            }
            // 괄호면 그냥 [] 하나로 묶어서 타입에 저장
            else if (c=='['){
                type.add("[]");
            }
            else if (c=='&' || c=='*'){
                type.add(String.valueOf(c));
            }
        }
        // 나중에 기호를 앞으로 옮길때 역순으로 가기에 arrayList reverse
        Collections.reverse(type);

        varType = String.join("",type);
        varName =  String.join("",alphabet);

        output[0] = varType;
        output[1] = varName;

        return output;
    }


}
