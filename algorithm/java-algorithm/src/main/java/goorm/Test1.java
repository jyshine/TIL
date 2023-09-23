package goorm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Test1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 난이도의 문제 받기
        Set<Integer> questions = new HashSet<>();
        String str = br.readLine();
        String[] split = str.split(" ");
        for(int i = 0; i < N; ++i){
            questions.add(Integer.parseInt(split[i]));
        }

        if (questions.size() < 3) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }



    }
}
