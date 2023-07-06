package dynamicprogramming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class PermutationTest2 {


    public static void main(String[] args) {
        int k=20;
//        int[] numbers={3,7,2,8,6,4,5,1};
        int[] numbers= {10,40,30,20};
        long startTime = System.currentTimeMillis(); // 시작 시간 측정

        int answer=new Solution().solution(k, numbers);

        System.out.println(answer);
        long endTime = System.currentTimeMillis(); // 종료 시간 측정
        long executionTime = endTime - startTime; // 실행 시간 계산

        System.out.println("실행 시간: " + executionTime + "밀리초");

        System.out.println(answer);
    }
}

class Solution {

    static Set<Integer> answerSet = new HashSet<>();
    public int solution(int k, int[] numbers) {


        permutation(numbers, 0, 0, k, numbers.length);

        int answer = answerSet.stream().min(Integer::compare).orElse(-1);
        return answer;


    }

    static void permutation(int[] numbers, int depth, int cnt, int k, int N) {
        if (depth == N) {
            boolean flag = true;
            for (int i = 1; i < numbers.length; i++) {
                if (Math.abs(numbers[i - 1] - numbers[i]) > k) {
                    flag = false;
                    break;
                }

            }
            if (flag)
                answerSet.add(cnt);

//            System.out.println(Arrays.toString(numbers));
        }

        for (int i = depth; i < N; i++) {

            swap(numbers, depth, i);
            //swap 발생
            if (depth != i)
                permutation(numbers, depth + 1, cnt + 1, k, N);
                //depth==i
                //swap 발생 X
            else
                permutation(numbers, depth + 1, cnt, k, N);

            swap(numbers, depth, i);
        }
    }

    static void swap(int[] numbers, int depth, int i) {
        int tmp = numbers[depth];
        numbers[depth] = numbers[i];
        numbers[i] = tmp;
    }
}

