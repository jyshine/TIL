package goorm;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class ScabGame {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testRound = Integer.parseInt(br.readLine());

        for(int i=0; i<testRound;i++){
            String aInput = br.readLine();
            String bInput = br.readLine();

            String[] a = aInput.split(" ");
            String[] b = bInput.split(" ");

            int aLength = Integer.parseInt(a[0]);
            int bLength = Integer.parseInt(b[0]);


            HashMap<Integer, Integer> aResult = getResult(a, aLength);
            HashMap<Integer, Integer> bResult = getResult(b, bLength);

            String winner = "";

            for(int j=4; j>0 ; j--){
                if (aResult.get(j)>bResult.get(j)) {
                    winner = "A";
                    break;
                } else if (aResult.get(j)<bResult.get(j)) {
                    winner = "B";
                    break;
                } else {
                    winner = "D";
                }
            }
            System.out.println(winner);
        }
        System.out.println("");
    }

    private static HashMap<Integer, Integer> getResult(String[] inputArray, int inputArrayLength) {
        HashMap<Integer, Integer> result = new HashMap<>();
        result.put(1, 0);
        result.put(2, 0);
        result.put(3, 0);
        result.put(4, 0);

        for(int j = 1; j< inputArrayLength +1; j++) {
            switch (Integer.parseInt(inputArray[j])) {
                case 1 :
                    result.put(1, result.get(1) + 1);
                    break;
                case 2 :
                    result.put(2, result.get(2) + 1);
                    break;
                case 3 :
                    result.put(3, result.get(3) + 1);
                    break;
                case 4 :
                    result.put(4, result.get(4) + 1);
                    break;
            }

        }
        return result;
    }
}


