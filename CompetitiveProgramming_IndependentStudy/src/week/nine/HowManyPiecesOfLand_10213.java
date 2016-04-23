package week.nine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class HowManyPiecesOfLand_10213 {

        public static void main(String[] args) throws IOException {

                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                StringBuilder bldr = new StringBuilder();
                int cases = Integer.parseInt(br.readLine());

                for (int i = 0; i < cases; i++) {
                        int x = Integer.parseInt(br.readLine());
                        bldr.append(land(x)).append("\n");
                }
                System.out.println(bldr.toString());
        }

        private static BigInteger land(int x) {
                // TODO Auto-generated method stub

                BigInteger big = BigInteger.valueOf(x);

                big = (big.pow(4)).subtract((big.pow(3)).multiply(BigInteger.valueOf(6)))
                                .add((big.pow(2)).multiply(BigInteger.valueOf(23)))
                                .subtract(big.multiply(BigInteger.valueOf(18))).add(BigInteger.valueOf(24));

                // .add(BigInteger.valueOf(24));
                return big.divide(BigInteger.valueOf(24));
        }

}
