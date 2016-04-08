package week.one;

/**
 * 
 * Submitted, Accepted
 * 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.LinkedList;

class HowManyTrees_10303 {

        public static void main(String[] args) {

                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                String set;
                try {
                        LinkedList<Integer> allInputs = new LinkedList<Integer>();

                        BigInteger[] vals = preCompute();
                        
                        while ((set = br.readLine()) != null) {
                                // System.out.println("HERE");

                                System.out.println(vals[Integer.parseInt(set)]);
                                
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

        private static BigInteger[] preCompute() {
                // TODO Auto-generated method stub
                BigInteger[] vals = new BigInteger[1001];
                
                vals[1] = BigInteger.ONE;
                BigInteger four = new BigInteger("4");
                BigInteger two = new BigInteger("2");
                
                for(int i = 2; i <= 1000; i++){
                        
                        // [(4n+2)vals[n-1] / (n+2)]
                        BigInteger n = new BigInteger(String.valueOf(i-1));
                        
                        vals[i] = (((four.multiply(n)).add(two)).multiply(vals[i-1])).divide(n.add(two));
                        
                }
                
                return vals;
        }

}
