package Week4;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class AtoB {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int A = Integer.parseInt(str[0]);
        int B = Integer.parseInt(str[1]);
        int cnt = 1;
        while (true) {
            if (B == A) {    // 성공
                System.out.print(cnt);
                return;
            } else if (B < A) {
                System.out.print("-1");
                return;
            } else if (B % 2 == 0) {  // 2로나눠지면 1번연산을 적용한 결과
                B = B / 2;
                cnt++;
            } else if (B % 10 == 1) {      // 안나눠질때 끝에 1이 있으면 2번연산 결과
                B = B / 10;
                cnt++;
            } else { // 위 조건문 모두 만족하지 못하면 -1
                System.out.print("-1");
                return;
            }
        }
    }
}

// 완전이진트리
// Level 하나 만들면서 바로 탐색하면 안될까 ? 어차피 레벨 n의 시작 인덱스는 2^n  그리고 마지막 인덱스는 2^(n+1)-1
// level 하나 생기면서 바로 탐색하고 없으면 다음 레벨 생성하고 바로 탐색
//public static void bfs(int root,int inputValue){
//    Queue<Integer> q = new LinkedList<>();
//    ArrayList<Integer> graph = new ArrayList<>();
//
//    q.add(root);
//    graph.add(0);
//    graph.add(root);
//
//
//    long depth = 1;
//    double nodeCnt = Math.pow(2,depth);
//    double nodeNum = nodeCnt;
//    int parentNodeNum ;
//    Integer parentValue;
//    int firstCal;
//    int secondCal;
//
//    while(true){
//        // graph 노드 추가 및 값 탐색 진행할
//        // i = 다음으로 삽입될 노드의 인덱스, nodeCnt = 동일 Level 에서의 마지막 노드 인덱스
//        for (double i = nodeNum; i < (nodeCnt*2); i++) {
//            // 노드 생성 -> graph 삽입
//            // 삽입 노드의 부모 노드 값을 가져와서 연산 수행
//            parentNodeNum = (int) (nodeNum/2);
//            parentValue = graph.get(parentNodeNum);
//
//            firstCal = parentValue*2;
//            secondCal = Integer.parseInt(Integer.toString(parentValue)+"1");
//            if(firstCal==inputValue || secondCal==inputValue){
//                System.out.print(depth);
//                return;
//            }
//            graph.add(firstCal);
//            graph.add(secondCal);
//
//        }
//        //TODO 탐색진행
//        for ()
//
//            depth++;
//
//        break;
//
//    }
//
//}

