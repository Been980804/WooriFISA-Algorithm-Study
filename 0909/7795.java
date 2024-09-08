  import java.io.*;
    import java.util.*;

    public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine()); // 테스트 케이스 개수 입력

            for (int i = 0; i < N; i++) {
                ///////////////////////////////////////////// 입력 처리 /////////////////////////////////////////////

                // 각 테스트 케이스의 A와 B 입력
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());


                List<Integer> listA = new ArrayList<>();
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < A; j++) {
                    listA.add(Integer.parseInt(st.nextToken()));
                }


                List<Integer> listB = new ArrayList<>();
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < B; j++) {
                    listB.add(Integer.parseInt(st.nextToken()));
                }

                Collections.sort(listA);
                Collections.sort(listB);

                int answer = 0;
                int bP = 0;

                for (int a : listA) {
                    // listB의 요소들 중 a보다 작은 것들을 모두 건너뛰기
                    while (bP < B && listB.get(bP) < a) {
                        bP++;
                    }
                    // 현재 listB에서 a보다 작은 값들이 몇 개인지 카운트
                    answer += bP;
                }


                System.out.println(answer);
            }
        }
    }