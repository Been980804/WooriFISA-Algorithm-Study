package Week3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class plus123 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] Input = new int[N];
        for(int i=0; i<N; i++) {
            Input[i] = Integer.parseInt(br.readLine());
        }
        // N이 11이하인 양수이므로, index가 1이면 1에대한 값을 나타내기 위해.
        int[] ary = new int[12];
        ary[1] = 1;
        ary[2] = 2;
        ary[3] = 4;
        for(int i = 4; i<=11; i++){
            ary[i] = ary[i-1] + ary[i-2] + ary[i-3];
        }
        for(int v : Input){
            System.out.println(ary[v]);
        }

    }
}

/*  2 -> 1 + 1
                 2
            3 -> 1 + 2  -> 1 + 2, 1 + 1 + 1
                 2 + 1
                 3
            4 ->  1 + 3
                  1 || 1 + 2
                  1 || 1 + 1 + 1
                  1 || 2 + 1
                  1 || 3
                  2 + 2
                  2 || 1 + 1
                  2 || 2
                  3 + 1
                  3 || 1
           즉, 1, 2, 3 을 순서대로 써가며 1+ 뒤에 오는 수 i는   ans[i]의 값 만큼 방법이 있다.
           위 4의 경우 1 + 3  은 Input[3]에서의 값 만큼의 방법 개수이며
            2 + 2 는 2 + 다음에 오는 2 , ans[2]에서의 값이고
            3 + 1 은 3 + 다음에 오는 1 , ans[1]에서의 값이다.
           5의 경우
           1 + 4  Input[4]에서의 값
           2 + 3  Input[3]에서의 값
           3 + 2  Input[2]에서의 값.
           그렇다면 왜  4 + 1  이건 안고려하는가에 대한 것은 문제에서 1,2,3 만을 사용하라 하였기 때문이다.
           1 + 4 같은 경우의 4는 4일때 1,2,3으로 표현할 수 있는 방법의 개수를 구하였지 4를 사용한 것이 아니다.
         */