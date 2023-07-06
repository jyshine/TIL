package dynamicprogramming;

import java.util.Arrays;

public class PermutationTest4 {
    public static void main(String[] args) {
        int k=3;
//        int k=20;
        int[] numbers={3,7,2,8,6,1,5,4};
//        int[] numbers= {10,40,30,20};
        int answer=new Solution4().solution(k, numbers);
        System.out.println(answer);
    }
}
class Solution4{
    /**
     * [10, 40, 30, 20]
     * [0] - [1]
     * 10  - 40 = -30
     *
     * [10, 20, 30, 40]
     * [10, 20, 30, 40]
     *
     */
    //  0  1  2 3
    // 10 40 30 20
    // [0] - [1]
    // 10  - 40 = -30
    // 30 > k
    // swap
    // 0 2 3
    // 10 30 20
    // 10 - 30
    // 20
    //
    public int solution(int k, int[] numbers) {
        int answer = 0;

        for (int i=0; i<numbers.length-1; i++){

            System.out.println(Arrays.toString(numbers));

            int diff = Math.abs(numbers[i] - numbers[i + 1]);

            if (diff > k) {
                int minDiff = Integer.MAX_VALUE;
                int minDiffIndex = -1;

                for (int j = i+2; j < numbers.length; j++){
                    int newDiff = numbers[j] - numbers[i];
                    System.out.println(newDiff);
                    if(newDiff <= k && newDiff < minDiff) {
                        minDiff = newDiff;
                        minDiffIndex = j;
                    }
                }

                if (minDiffIndex != -1) {
                    int temp = numbers[minDiffIndex];
                    numbers[minDiffIndex] = numbers[i + 1];
                    numbers[i + 1] = temp;
                } else {
                    int temp = numbers[i + 1];
                    numbers[i + 1] = numbers[i];
                    numbers[i] = temp;
                }

                answer++;
            }
        }


        return answer;
    }


}

