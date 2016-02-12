package week.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BigMod_374 {

        public static void main(String[] args) {

                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                String val;

                try {
                        while ((val = br.readLine()) != null) {

                                if (!val.equals("")) {

                                        long B = Integer.parseInt(val);
                                        long P = Integer.parseInt(br.readLine());
                                        long M = Integer.parseInt(br.readLine());

                                        System.out.println(calculateBigMod(B, P, M));
                                }
                        }
                } catch (IOException e) {
                        // TODO Auto-generated catch block
                        // e.printStackTrace();
                        System.exit(0);
                }

        }

        private static long calculateBigMod(long b, long p, long m) {
                // TODO Auto-generated method stub

                if (m == 1)
                        return 0;

                long modValue = 1;

                for (int i = 1; i <= p; i++) {
                        modValue = (modValue * b) % m;
                }

                return modValue;
        }

}
