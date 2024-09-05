package Week2;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.io.BufferedReader;

// 그냥 for문 돌리면 n^2의 시간복잡도가 나옴
// nlgn 이나 lgn이 나오면 best

// Idea #1 정렬을 수행한 뒤 리스트 인덱스가 곧 자신보다 작은 것들의 개수를 나타낸다.
// 문제점1. 중복의 경우 어떻게해야할까?
//        1) 우선 입력받은 값을 list_input 이라고 하자. list_input 을 set으로 변환하여 중복 제거
//        2) set을 리스트로 변환한 후 collections.sort 함수 사용하여 정렬
//        3) list_A에서 원소 하나 x를 뽑음 -> list_B에서 x와 일치하는 값의 인덱스 가져옴
// Collections.sort 는 최악 O(nlog(n))의 시간복잡도를 가진다고 함.

public class coordinateCompression {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list_input = new ArrayList<>();

        int N = Integer.parseInt(reader.readLine());


        String[] input = reader.readLine().split(" ");
        for (String s : input){
            list_input.add(Integer.parseInt(s));
        }

        // 중복 제거 및 정렬
        Set<Integer> list2set = new HashSet<>(list_input);
        List<Integer> sortedList = new ArrayList<>(list2set);
        Collections.sort(sortedList);
        for(int v : list_input){
            System.out.print(sortedList.indexOf(v) + " ");
        }

    }
}
