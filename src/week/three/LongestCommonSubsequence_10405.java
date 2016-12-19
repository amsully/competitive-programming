package week.three;

/*
 * 
 * ACCEPTED
 * 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestCommonSubsequence_10405 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String firstStr;

        while ((firstStr = br.readLine()) != null) {
            if (firstStr.length() == 0) break;
            String secondStr = br.readLine();

            char[] strOne;
            char[] strTwo;

            if (firstStr.length() > secondStr.length()) {
                strOne = ("." + firstStr).toCharArray();
                strTwo = ("," + secondStr).toCharArray();
            } else {
                strTwo = ("." + firstStr).toCharArray();
                strOne = ("," + secondStr).toCharArray();

            }


            int[] prevRow = new int[strTwo.length];
            int[] currRow = new int[strTwo.length];

            for (int i = 1; i < strOne.length; i++) {

                prevRow = currRow;
                currRow = new int[strTwo.length];

                for (int j = 1; j < strTwo.length; j++) {

                    if (strOne[i] == strTwo[j]) {

                        currRow[j] = Math.max(prevRow[j], Math.max(prevRow[j - 1] + 1, currRow[j - 1]));

                    } else {
                        currRow[j] = Math.max(currRow[j - 1], prevRow[j]);
                    }

                }
                // System.out.println(Arrays.toString(currRow));

            }

            System.out.println(currRow[currRow.length - 1]);
        }
    }

}
