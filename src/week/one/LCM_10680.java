package week.one;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class LCM_10680 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int val;

        System.out.println("START");
        ArrayList<BigInteger> results = getAllLCMFromIntRange(1000000);
        System.out.println("END");

        while ((val = scan.nextInt()) != 0) {

//                        System.out.println(results.get(val).mod(new BigInteger("10")).toString());
            String lcm = String.valueOf(results.get(val)).replace("0", "");

//                        System.out.println(lcm);
            System.out.println(lcm.charAt(lcm.length() - 1));

        }

    }

    private static ArrayList<BigInteger> getAllLCMFromIntRange(int val) {
        // TODO Auto-generated method stub

//                BigInteger lcmResult = BigInteger.ZERO;

        ArrayList<BigInteger> results = new ArrayList<BigInteger>();// ;[100000];

        results.add(BigInteger.ZERO);
        results.add(BigInteger.ONE);

//                BigInteger i = new BigInteger("2");


        for (int i = 2; i <= val; i++) {

//                        lcmResult = getLCM(lcmResult, new BigInteger(String.valueOf(i)));
            System.out.println(i);
            results.add(getLCM(results.get(i - 1), i));
//                        System.out.println(i);
        }

        return results;
    }

    private static BigInteger getLCM(BigInteger a, int b) {
        // TODO Auto-generated method stub

        return a.multiply((new BigInteger(String.valueOf(b / (getGCD(a, b))))));

    }

    private static int getGCD(BigInteger a, int b) {
        // TODO Auto-generated method stub
        while (b != 0) {
            int temp = b;

            BigInteger modul = new BigInteger(String.valueOf(b));


            b = a.mod(modul).intValue(); //a % b;

            a = new BigInteger(String.valueOf(temp)); // TODO: REALLY?
//                        System.out.println(a.toString());
        }
        return a.intValue();
    }


}
