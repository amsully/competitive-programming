package week.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;

class HowManyTrees_10303_Recursive {

        // static int count;

        public static void main(String[] args) {

                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                String set;
                try {
                        LinkedList<Integer> allInputs = new LinkedList<Integer>();

                        while ((set = br.readLine()) != null) {
                                // System.out.println("HERE");

                                int N = Integer.parseInt(set);
                                System.out.println(countTrees(N));
                        }

                } catch (NumberFormatException e) {
                        // System.exit(0);
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                } catch (IOException e) {
                        // System.exit(0);
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }

                System.exit(0);
        }

        private static int countTrees(int set) {
                // TODO Auto-generated method stub
                // System.out.print(" ");
                // System.out.println("Set: " + set);
                if (set == 3) {
                        return 5;
                } else if (set == 2) {
                        return 2;
                } else if (set <= 1) {
                        return 1;
                } else {

                        int count = 0;

                        for (int i = 1; i <= set; i++) {
                                int left = countTrees(i - 1);
                                int right = countTrees(set - i);
                                count += (left * right);
                        }
                        // System.out.println("Set:"+set+" Count:" +count);

                        return count;
                }
        }

}
