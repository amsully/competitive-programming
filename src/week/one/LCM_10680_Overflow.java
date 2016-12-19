package week.one;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class LCM_10680_Overflow {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int val;

//                System.out.println("START");
        ArrayList<Long> results = getAllLCMFromIntRange(1000000);
//                System.out.println("END");

        while ((val = scan.nextInt()) != 0) {

            System.out.println(results.get(val));
            String lcm = String.valueOf(results.get(val)).replace("0", "");

//                        System.out.println(lcm);
            System.out.println(lcm.charAt(lcm.length() - 1));

        }

    }

    private static ArrayList<Long> getAllLCMFromIntRange(int val) {
        // TODO Auto-generated method stub

        long lcmResult = 1;

        ArrayList<Long> results = new ArrayList<Long>();// ;[100000];

        results.add((long) 0);
        results.add((long) 1);

        for (int i = 2; i <= val; i++) {

            lcmResult = getLCM(lcmResult, i);
            results.add(lcmResult);
        }

        return results;
    }

    private static long getLCM(long a, long b) {
        // TODO Auto-generated method stub

        return a * (b / getGCD(a, b));

    }

    private static long getGCD(long a, long b) {
        // TODO Auto-generated method stub
        while (b != 0) {
            long temp = b;

            b = a % b;

            a = temp;

        }
        return a;
    }

}
