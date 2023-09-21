package goorm;

import java.io.*;

public class AIVacuum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int i=0; i<testCase; i++) {
            String[] arry = br.readLine().split(" ");
            int x = Integer.parseInt(arry[0]);
            int y = Integer.parseInt(arry[1]);
            int n = Integer.parseInt(arry[2]);

            int distance = Math.abs(x) + Math.abs(y);

            System.out.println(distance);
            if (distance > n || (distance - n) % 2 != 0) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }

        }
    }
}
