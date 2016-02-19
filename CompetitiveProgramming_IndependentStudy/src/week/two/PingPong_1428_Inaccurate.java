package week.two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class PingPong_1428_Inaccurate {
        
        final static int MAX = 100010;
        static byte[] arr1 = new byte[100010];
        static byte[] arr2 = new byte[100010];
        static byte[] arr = new byte[100010];
        static byte[] c = new byte[100010];
       
        public static void main(String[] args) throws IOException{
                

                
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                
                Integer trials = Integer.valueOf(br.readLine());

                for(int i = 0 ; i < trials; i++){

                        
                        String[] str = br.readLine().split(" ");
                        
                        Integer numberOfPlayers = Integer.valueOf(str[0]);
                        
                        
                        for(int j = 0; j < numberOfPlayers; j++){
                                arr[j] = Byte.valueOf(str[j]);   
                        }
                        
                        Arrays.fill(c, (byte)0);
                        for(int j = 0; j < numberOfPlayers; j++){

                                add(arr[j]);
                                
                                arr1[j] = sum((byte) (arr[j]-1));
                        }
                        
                        Arrays.fill(c,(byte) 0);
                        for(int j = numberOfPlayers-1; j >= 0; j--){
                                add(arr[j]);
                                
                                arr2[j] = sum((byte) (arr[j] -1));
                        }
                        int answer = 0;
                        
                        for(int j = 1; j < numberOfPlayers - 1; j++){
                                answer += arr1[j] * (numberOfPlayers - j - 1 - arr2[j]) + arr2[j] * (j - arr1[j]);
                                
                        }
                        System.out.println(answer);
                        
//                        System.out.println(arr.toString());
                        
                }
        }

        private static byte sum(byte i) {
                // TODO Auto-generated method stub
                int val = 0;
                while(i > 0){
                        val += c[i];
                        i -= lowestTwoFactor(i);
                }
                return (byte)val;
        }

        private static void add(byte val) {
                // TODO Auto-generated method stub
                
                while(val < MAX){
                        c[val] = (byte) (c[val]+ 1); // lowestTwoFactor(val);
                        val += lowestTwoFactor(val);
                }
        }

        private static byte lowestTwoFactor(Byte val) {
                // TODO Auto-generated method stub
                return (byte) (val & -val);
        }

        
        
        
}
