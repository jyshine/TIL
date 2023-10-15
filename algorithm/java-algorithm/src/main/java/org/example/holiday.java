package org.example;

import java.util.HashMap;
import java.util.Map;

public class holiday {
    public static void main(String[] args) {
        int[][] dates = {
                {1, 1}, {1, 21}, {1, 22}, {1, 23},
                {3, 1}, {5, 5}, {5, 27}, {6, 6},
                {8, 15}, {9, 28}, {9, 29}, {9, 30},
                {10, 3}, {10, 9}, {12, 25}
        };

        Map<Integer, Integer> holidayMap = new HashMap<>();



        int[] calender = {31,28,31,30,31,30,31,31,30,31,30,31};

        int X = 7;
        int sum = 0;
        for (int i=0; i<calender.length;i++) {
            for (int j=0; j<calender[i]; j++) {
                System.out.println(String.valueOf(i+1) + " / "+String.valueOf(j+1));

                for (int[] date : dates) {
                    if (X<6&&i+1==date[0] && j+1==date[1]){
                        sum = sum + 1;
                    }
                    if (X>5&&i+1==date[0] && j+1==date[1]){
                        sum = sum + 1;
                    }


                }

                if(X>5) {
                    sum = sum + 1;

                }

                if (X==7){
                    X = 1;
                } else {
                    X++;
                }

            }
        }

        System.out.println(sum);

    }



}
