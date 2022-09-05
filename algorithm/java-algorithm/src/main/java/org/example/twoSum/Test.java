package org.example.twoSum;

import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int targer){
        for(int i=0; i<nums.length; i++){
            for (int j = i + 1; j < nums.length; j++) {
                if (targer == nums[i] +nums[j]){
                    return new int[]{nums[i],nums[j]};
                }

            }

        }
        throw new IllegalArgumentException();


    }
}

class Solution2 {
    public int[] twoSum(int[] nums, int target){
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++){
            hashMap.put(nums[i], i);
        }

        for(int i=0; i<nums.length; i++){
            Integer i2 = hashMap.get(target - nums[i]);
            if(i2 != null && i != i2) {
                return new int[]{nums[i], nums[i2]};
            }
        }
        throw new IllegalArgumentException();

    }
}

class Solution3 {
    public int[] twoSum(int[] nums, int target){
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++){
            if(hashMap.containsKey(target-nums[i])){
                return new int[]{nums[i], target - nums[i]};
            } else {
                hashMap.put(nums[i], i);
            }
        }


        throw new IllegalArgumentException();

    }
}
public class Test {
    public static void main(String[] args) {
        int[] nums = {6, 4, 3, 8, 7, 5, 2};
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();
        Solution3 solution3 = new Solution3();
        int[] result = solution.twoSum(nums, 5);
        int[] result2 = solution2.twoSum(nums, 5);
        int[] result3 = solution3.twoSum(nums, 5);
        System.out.println(result[0] + " , "+ result[1]);
        System.out.println(result2[0] + " , "+ result2[1]);
        System.out.println(result3[0] + " , "+ result3[1]);
    }
}
