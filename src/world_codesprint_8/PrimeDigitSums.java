package world_codesprint_8;

/**
 * Created by ams on 12/18/16.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class PrimeDigitSums {
    HashSet<String> memoiz = new HashSet<String>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int n = in.nextInt();
            // your code goes here
            System.out.println( calculate(n)%(10000000 + 7) );

        }
    }

    static public int calculate(int n){
        int result = 0;



        return result;
    }
}
