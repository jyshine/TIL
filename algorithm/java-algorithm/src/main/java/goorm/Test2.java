package goorm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Test2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] intputSplit = input.split(" ");
        int n = Integer.parseInt(intputSplit[0]);
        int k = Integer.parseInt(intputSplit[1]);

        String inputArray = br.readLine();

        int c = n - k;

        int result = c / (k - 1);
        int mod = c % (k - 1);
        result = result + 1;
        if (mod > 0){
            result = result +1;
        }
        if(n <= k) {  // K가 N보다 크거나 같으면 1을 출력해준다.
            System.out.println(1);
        } else {
            System.out.println(result);
        }



    }
}

