package algorithm.hyeonbeen.week1;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Greedy2 {
    
    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine()); // 강의 수

        int[][] course = new int[N][2];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            String[] parts = line.split(" ");
            course[i][0] = Integer.parseInt(parts[0]); // start
            course[i][1] = Integer.parseInt(parts[1]); // end
        }

        Arrays.sort(course, Comparator.comparingInt(i -> i[0])); // start 기준(오름차순)으로 정렬 -> 빨리 시작하는 순서

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            if (!queue.isEmpty() && queue.peek() <= course[i][0]) // queue가 비어있으면 삽입 / end랑 start 비교 같거나 크면
                queue.poll();                                     // 이전 강의 제거
            queue.add(course[i][1]);
        }

        System.out.println(queue.size());                         // queue.size() = 강의실 수
    }
}
