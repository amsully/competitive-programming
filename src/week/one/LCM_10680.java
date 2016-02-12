package week.one;

import java.util.HashMap;
import java.util.Scanner;

public class LCM_10680 {

        public static void main(String[] args){
                
                Scanner scan = new Scanner(System.in);
                
                HashMap<Integer, Integer> computed = new HashMap<Integer, Integer>();
                
                int val;
                
                while((val = scan.nextInt()) != 0){
                        
                        System.out.println(getLCM(val));
                        
                }
                
        }

        private static char[] getLCM(int val) {
                // TODO Auto-generated method stub
                
                Integer gcd = getGCD(val-1,val);
                
                return null;
        }

        private static Integer getGCD(int val, int val2) {
                // TODO Auto-generated method stub
                while(val != 0){
                        
                }
                return val2;
        }
        
}
