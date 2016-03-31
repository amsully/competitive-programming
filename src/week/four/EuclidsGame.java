package week.four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EuclidsGame {

        public static void main(String[] args) throws IOException{
                
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                
                String scan;
                
                while( !(scan = br.readLine()).equals("0 0")){
                        
                        StringTokenizer tokenizer = new StringTokenizer(scan);
                        
                        int one = Integer.parseInt(tokenizer.nextToken());
                        int two = Integer.parseInt(tokenizer.nextToken());
                        
                        int big = Math.max(one, two);
                        int small = Math.min(one, two);
                        
                        boolean result = getResult(small, big);
                        
                        if(result){System.out.println("Stan wins");}else{System.out.println("Ollie wins");}
                        
//                        while(mod != 0){
//                                
//                                int res = big % mod;
//                                big = mod;
//                                mod = res;
//                                count++;
//                        }
//                        if(count%2 == 0)
//                                System.out.println("Ollie wins");
//                        else{
//                                System.out.println("Stan wins");
//                        }
                        
                }
                
        }

        private static boolean getResult(int small, int big) {

                if( small == 0 ) return false;
                if(big % small == 0) return true;
                
                boolean res = false;
                
                for(int i = (big/small); i >= 1; i--){
                        int newBig = (big-(small*i));
                        res |= !getResult(Math.min(small, newBig), Math.max(small, newBig));
                        
                        if( res ) break;
                }
                
                return res;
        }
        
}
