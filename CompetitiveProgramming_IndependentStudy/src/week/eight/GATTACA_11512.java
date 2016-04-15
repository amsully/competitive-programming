package week.eight;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/*
 * Attempted LCS, did not use tries to start.
 */

class GATTACA_11512 {

        static int[][] lcs;
        static int[][] prevX;
        static int[][] prevY;
        static boolean[][] vis;
        static boolean[][] charMatch;
        static HashMap<String, Integer> candidates = new HashMap<String, Integer>();
        static String result;
        static String read;
        static Integer count;

        public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                int trials = Integer.parseInt(br.readLine());

                for (int i = 0; i < trials; i++) {
                        solve(br.readLine());
                        print();
                }

        }

        private static void solve(String readLine) {
                // TODO Auto-generated method stub
                init(readLine.length());
                read = readLine;

                for (int i = 0; i < readLine.length(); i++) {
                        for (int j = i; j < readLine.length(); j++) {

                                if (i == 0 && j == 0) {
                                        lcs[0][0] = 1;
                                        charMatch[0][0] = true;
                                        // }
                                        //
                                        // else if (i == 0) {
                                        //
                                        // lcs[0][j] = lcs[0][j - 1];
                                        // prevX[i][j] = 0;
                                        // prevY[i][j] = j - 1;
                                        // if (readLine.charAt(i) ==
                                        // readLine.charAt(j)) {
                                        // charMatch[i][j] = true;
                                        // }
                                        //
                                        // } else if (j == 0) {
                                        // lcs[i][0] = lcs[i - 1][0];
                                        // prevX[i][j] = i - 1;
                                        // prevY[i][j] = 0;
                                        // if (readLine.charAt(i) ==
                                        // readLine.charAt(j)) {
                                        // charMatch[i][j] = true;
                                        // }
                                } else {
                                        solveHelper(readLine, i, j);
                                }

                        }
                }

                System.out.println(result());

        }

        private static String result() {
                // TODO Auto-generated method stub

                for (int i = lcs.length - 1; i >= 0; i--) {
                        for (int j = lcs.length - 1; j >= 0; j--) {

                                if (charMatch[i][j]) {
                                        addStr(i, j);
                                }

                        }
                }

                if (result.length() == 0) {
                        return "No repetitions found!";
                }

                int count = candidates.get(result);
                StringBuilder bldr = new StringBuilder();
                bldr.append(result);
                bldr.reverse();
                String format = bldr.toString() + " " + count;
                return format;
        }

        private static void addStr(int i, int j) {
                // TODO Auto-generated method stub
                String str = "";

                while (charMatch[i][j] && !vis[i][j]) {

                        str = str + read.charAt(i);



                        
                        if(!vis[i][j]){

                                if (candidates.containsKey(str)) {
                                        candidates.put(str, candidates.get(str) + 1);
                                        if (str.length() == result.length()) {
                                                if (result.compareTo(str) < 0) {
                                                        result = str;
                                                }

                                        } else if (str.length() > result.length()) {
                                                result = str;
                                        }
                                } else {
                                        candidates.put(str, 1);
                                }    
                        }
                        
                        vis[i][j] = true;
                        
                        int newI = prevX[i][j];
                        int newJ = prevY[i][j];
                        i = newI;
                        j = newJ;
                        

                        if (i == 0 || j == 0)
                                break;

                }

//                if (candidates.containsKey(str)) {
//                        candidates.put(str, candidates.get(str) + 1);
//                        if (str.length() == result.length()) {
//                                if (result.compareTo(str) < 0) {
//                                        result = str;
//                                }
//
//                        } else if (str.length() > result.length()) {
//                                result = str;
//                        }
//                } else {
//                        candidates.put(str, 1);
//                }

        }

        private static void solveHelper(String readLine, int i, int j) {
                // TODO Auto-generated method stub
                if (readLine.charAt(i) == readLine.charAt(j)) {

                        if (i == 0 || j == 0) {
                                lcs[i][j] = 1;
//                                charMatch[i][j] = true;

                        } else {

                                lcs[i][j] = lcs[i - 1][j - 1] + 1;
                                prevX[i][j] = i - 1;
                                prevY[i][j] = j - 1;
                                charMatch[i][j] = true;
                        }
                }

                // else if (lcs[i][j-1] > lcs[i-1][j]) {
                // lcs[i][j] = lcs[i][j-1];
                // prevX[i][j] = i ;
                // prevY[i][j] = j-1;
                // } else {
                // lcs[i][j] = lcs[i-1][j];
                // prevX[i][j] = i-1;
                // prevY[i][j] = j;
                // }
        }

        private static void init(int l) {
                // TODO Auto-generated method stub
                lcs = new int[l][l];
                prevX = new int[l][l];
                prevY = new int[l][l];
                charMatch = new boolean[l][l];
                vis = new boolean[l][l];
                result = "";
                candidates.clear();
        }

        public static void print() {
                StringBuilder bldr = new StringBuilder();
                for (int i = 0; i < lcs.length; i++) {

                        for (int j = 0; j < lcs[0].length; j++) {
                                bldr.append(lcs[i][j] + " ");
                        }
                        bldr.append("\n");
                }
                for (int i = 0; i < lcs.length; i++) {

                        for (int j = 0; j < lcs[0].length; j++) {
                                bldr.append(charMatch[i][j] + " ");
                        }
                        bldr.append("\n");
                }

                System.out.println(bldr.toString());
                
                for(String val : candidates.keySet()){
                        System.out.println(val + " " + candidates.get(val));
                }
        }

}
