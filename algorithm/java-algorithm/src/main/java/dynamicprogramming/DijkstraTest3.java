package dynamicprogramming;
class Solution6 {
    public int solution(int k, int[] numbers) {
        int answer = 0;

        for (int i = 0; i < numbers.length - 1; i++) {
            int diff = Math.abs(numbers[i] - numbers[i + 1]);

            if (diff > k) {
                int minDiffIndex = findMinDiffIndex(numbers, i, k);

                if (minDiffIndex != -1) {
                    swap(numbers, minDiffIndex, i + 1);
                } else {
                    swap(numbers, i, i + 1);
                }

                answer++;
            }
        }

        return answer;
    }

    private int findMinDiffIndex(int[] numbers, int currentIndex, int k) {
        int minDiff = Integer.MAX_VALUE;
        int minDiffIndex = -1;

        for (int i = currentIndex + 2; i < numbers.length; i++) {
            int newDiff = numbers[i] - numbers[currentIndex];
            if (newDiff <= k && newDiff < minDiff) {
                minDiff = newDiff;
                minDiffIndex = i;
            }
        }

        return minDiffIndex;
    }

    private void swap(int[] numbers, int index1, int index2) {
        int temp = numbers[index1];
        numbers[index1] = numbers[index2];
        numbers[index2] = temp;
    }
}

public class DijkstraTest3 {
    public static void main(String[] args) {
        int k=3;
//        int k=20;
        int[] numbers={3,7,2,8,6,1,5,4};
//        int[] numbers= {10,40,30,20};
        int answer=new Solution6().solution(k, numbers);
        System.out.println(answer);
    }
}
