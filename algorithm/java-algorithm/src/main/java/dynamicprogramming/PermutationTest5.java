package dynamicprogramming;

public class PermutationTest5 {
    public static void main(String[] args) {
        int k=3;
//        int k=20;
        int[] numbers={3,7,2,8,6,4,5,1};
//        int[] numbers= {10,40,30,20};

        long startTime = System.currentTimeMillis(); // 시작 시간 측정

        int swapCount = minSwapCount(numbers, k);

        System.out.println(swapCount);
        long endTime = System.currentTimeMillis(); // 종료 시간 측정
        long executionTime = endTime - startTime; // 실행 시간 계산

        System.out.println("실행 시간: " + executionTime + "밀리초");
    }

    public static int minSwapCount(int[] numbers, int k) {
        int swapCount = 0;
        int n = numbers.length;

        for (int i = 0; i < n - 1; i++) {
            int diff = numbers[i + 1] - numbers[i];
//            System.out.println(i);
            if (diff > k) {
                int minDiff = Integer.MAX_VALUE;
                int minDiffIndex = -1;

                // 현재 요소와 k 차이가 k 이하인 다른 요소를 찾음
                for (int j = i + 2; j < n; j++) {
//                    System.out.println("    "+j);
                    int newDiff = numbers[j] - numbers[i];
                    System.out.println(newDiff);
                    if (newDiff <= k && newDiff < minDiff) {
                        minDiff = newDiff;
                        minDiffIndex = j;
                    }
                }

                // k 차이가 가장 작은 요소와 swap
                int temp;
                if (minDiffIndex != -1) {
                    temp = numbers[minDiffIndex];
                    numbers[minDiffIndex] = numbers[i + 1];
                    numbers[i + 1] = temp;
                } else {
                    // 현재 요소와 그 다음 요소 사이의 차이를 최소화하여 swap
                    temp = numbers[i + 1];
                    numbers[i + 1] = numbers[i];
                    numbers[i] = temp;
                }
                swapCount++;
            }
        }

        return swapCount;
    }
}
