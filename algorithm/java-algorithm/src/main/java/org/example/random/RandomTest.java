package org.example.random;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;

public class RandomTest {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i=0; i<500000000; i++){
            boolean isRepeat = true;
            int count = 0;
            while(isRepeat){
                count++;
                if((int) (Math.random() * 45) +1 == 45){
                    isRepeat = false;
                }
            }
            arrayList.add(count);
//            System.out.println(count);
        }
        IntSummaryStatistics intSummaryStatistics = arrayList.stream().mapToInt(num -> num).summaryStatistics();

        System.out.println(intSummaryStatistics.getAverage());

    }
}
