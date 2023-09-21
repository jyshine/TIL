package goorm;

import java.io.*;
import java.util.Scanner;

public class AIVacuum2 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int testCase = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < testCase; i++) {
            String[] input = scanner.nextLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            int t = Integer.parseInt(input[2]);

            String result = absoluteValueSolution(x, y, t);
            System.out.println(result);
        }
    }

    public static String absoluteValueSolution(int x, int y, int t) {

        int distance = Math.abs(x) + Math.abs(y);
        System.out.println(distance);
        if (distance > t || (distance - t) % 2 != 0) {
            return "NO";
        }
        return "YES";
    }
}
