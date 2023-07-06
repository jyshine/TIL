package dynamicprogramming;

class PermutationTest{
    private static int minSwapCount;

    public static int findMinimumSwap(int[] numbers, int k) {
        minSwapCount = Integer.MAX_VALUE; // 최소 swap 횟수 초기화
        backtrack(numbers, 0, k, 0); // 순열 생성 및 swap 횟수 계산
        return minSwapCount;
    }

    private static void backtrack(int[] numbers, int start, int k, int count) {
        if (start == numbers.length) {
            // 순열 생성 완료
            minSwapCount = Math.min(minSwapCount, count);
        } else {
            if (count >= minSwapCount) {
                return; // 이미 최소값을 초과하는 경우 종료
            }

            for (int i = start; i < numbers.length; i++) {
                swap(numbers, start, i); // 요소 교환
                int diff = (start > 0) ? Math.abs(numbers[start] - numbers[start - 1]) : Integer.MAX_VALUE;
                if (diff <= k) {
                    backtrack(numbers, start + 1, k, count); // 인접한 요소의 차이가 k 이하인 경우
                } else {
                    backtrack(numbers, start + 1, k, count + 1); // swap이 필요한 경우
                }
                swap(numbers, start, i); // 요소 원래 위치로 복원
            }
        }
    }

    private static void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    public static void main(String[] args) {
        int[] numbers1 = {10, 40, 30, 20};
        int k1 = 20;
        int minSwap1 = findMinimumSwap(numbers1, k1);
        System.out.println("Case 1 - Minimum swap count: " + minSwap1); // 최소 swap 횟수 출력

        int[] numbers2 = {3, 7, 2, 8, 6, 4, 5, 1};
        int k2 = 3;
        int minSwap2 = findMinimumSwap(numbers2, k2);
        System.out.println("Case 2 - Minimum swap count: " + minSwap2); // 최소 swap 횟수 출력
    }
}