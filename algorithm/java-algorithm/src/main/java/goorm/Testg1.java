package goorm;

import java.util.Scanner;

public class Testg1 {
    public static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력값을 읽어옴
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[][] gameBoard = new int[N][M];

        // 게임 판 데이터를 입력받음
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                gameBoard[i][j] = scanner.nextInt();
            }
        }

        // 주변 지뢰의 총합 계산
        int totalMines = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (gameBoard[i][j] != -1) {
                    int mines = 0;
                    for (int x = -1; x <= 1; x++) {
                        for (int y = -1; y <= 1; y++) {
                            int newRow = i + x;
                            int newCol = j + y;
                            if (newRow >= 0 && newRow < N && newCol >= 0 && newCol < M && gameBoard[newRow][newCol] == -1) {
                                mines++;
                            }
                        }
                    }
                    totalMines += mines;
                }
            }
        }

        // 결과 출력
        System.out.println(totalMines);

        scanner.close();
    }

//6
//        7 7 6 7 6 1
//        2 9 7 9 4 2
//        5 4 0 0 7 7
//        0 0 6 5 2 6
//        4 6 6 3 8 8
//        8 6 3 9 6 5
//        2 2
}
