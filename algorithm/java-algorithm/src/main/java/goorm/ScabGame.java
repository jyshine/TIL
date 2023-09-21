package goorm;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class ScabGame {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testRound = Integer.parseInt(br.readLine());


        for(int i=0; i<testRound; i++){

            List<Integer> aScores = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt)
                    .collect(Collectors.toList());

            List<Integer> bScores = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt)
                    .collect(Collectors.toList());

            Collections.sort(aScores);
            Collections.sort(bScores);

            int loopCount = aScores.size() > bScores.size() ? aScores.size() : bScores.size();

            String winner = "";
            for (int j=0;j<loopCount; j++){
                if (aScores.get(j)>bScores.get(j)){
                    winner = "A";
                    break;
                } else if (bScores.get(j)>aScores.get(j)) {
                    winner = "B";
                    break;
                }
                winner = "D";
            }

            System.out.println(winner);

        }
    }
}
