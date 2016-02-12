package week.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class BlackAndWhitePainting_11231 {

        public static void main(String[] args) {

                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                String next;

                try {
                        while ((next = br.readLine()) != null) {

                                String[] arr = next.split(" ");
                                
                                int n = Integer.parseInt(arr[0]);
                                int m = Integer.parseInt(arr[1]);
                                int w = Integer.parseInt(arr[2]);
                                
                                if(n==0 && m == 0 && w == 0){
                                        break;
                                }
                                
                                System.out.println(calculateBoard(n,m,w));

                        }
                } catch (IOException e) {
                        // TODO Auto-generated catch block
                        System.exit(0);
//                        e.printStackTrace();
                }

        }

        private static long calculateBoard(int n, int m, int w) {
                // TODO Auto-generated method stub
                long firstCalculation = calculateBoardHelper(n, m, w);

                long secondCalculation = 0;

                if (w == 1) {
                        secondCalculation = calculateBoardHelper(n - 1, m - 1, 1);
                } else {
                        secondCalculation = calculateBoardHelper(n - 1, m, 1);
                }
                return firstCalculation + secondCalculation;
        }

        private static long calculateBoardHelper(int n, int m, int w) {
                // TODO Auto-generated method stub
                
                
                int validCols = (m - Math.abs(w - 1) - 8);
                int validRows = (n - 8);
                if (validCols >= 0 && validRows >= 0) {

                        return (1 + validCols / 2) * (1 + validRows / 2);
                } else {
                        return 0;
                }

        }

}
