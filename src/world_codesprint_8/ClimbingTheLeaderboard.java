package world_codesprint_8;

/**
 * Created by ams on 12/17/16.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ClimbingTheLeaderboard {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> scores = new ArrayList<Integer>();
        int prevScore = -1;
        for(int scores_i=0; scores_i < n; scores_i++){
            int currScore = in.nextInt();

            if(prevScore != currScore){
                scores.add(currScore);
            }

            prevScore = currScore;
        }

        StringBuilder strbldr = new StringBuilder();
        int m = in.nextInt();
        int[] alice = new int[m];
        for(int alice_i=0; alice_i < m; alice_i++){
            alice[alice_i] = in.nextInt();

            int result = Collections.binarySearch(scores, alice[alice_i], Collections.reverseOrder());

            if(result >= 0){
                result += 1;
            }else{
                result = -result;
            }
            System.out.println(result);
//            strbldr.append(result + " ");
        }

//        String finalResult = strbldr.toString().trim();
//        System.out.println(finalResult);
        // your code goes here


    }
}
