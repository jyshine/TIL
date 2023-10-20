import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class test1 {
    public static void main(String[] args) {

        List<Integer> arr = new ArrayList<>();

//        arr.add(30);
//        arr.add(10);
//        arr.add(20);
//        arr.add(100);
//        arr.add(1);

//        arr.add(10);
//        arr.add(95);
//        arr.add(37);
//        arr.add(33);
//        arr.add(19);
//        arr.add(92);
//        arr.add(94);
//        arr.add(16);
//        arr.add(2);
//        arr.add(18);
//        arr.add(50);
//
        arr.add(25);
        arr.add(10);
        arr.add(20);
        Collections.sort(arr);

        Queue<Integer> queue = new LinkedList<>(arr);


        // 큐에서 두 개의 값을 꺼내서 합을 구하고 결과를 큐에 추가
        int sum = 0;
        int n = arr.size();

        int count =0;

        while (queue.size() >= 3) {

            Integer p1 = queue.poll();
            Integer p2 = queue.poll();
            sum = p1 + p2;
            queue.add(sum);

        }


        System.out.println(queue.poll()+queue.element()+queue.poll());

//        for(int i=0; i<n;i++){
//            queue.poll();
//            sum = 0;
//            for (int j=0; j<i;j++){
//                sum += arr.get(j) + arr.get(j + 1);
//            }
//            queue.add(sum);
//        }
//




    }
}
