package week.four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ANewStoneGame {

        public static void main(String[] args) throws IOException{
                
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                
                String scan;
                
                while(!(scan = br.readLine()).equals("0")){
                        
                       int numberOfPiles = Integer.parseInt(scan);
                       
                       if(numberOfPiles%2 == 1){
                               br.readLine();
                               System.out.println(1);
                       }else{
                               
                               StringTokenizer tokenizer = new StringTokenizer(br.readLine());
                               int result = 0;
                               int[] piles = new int[100];
                               for(int i = 0; i < numberOfPiles; i++){
                                       
                                       int heightOfPile = Integer.parseInt(tokenizer.nextToken());
                                       piles[heightOfPile]++;
                                       
                               }
                               for(int i = 0; i < 100; i++){
                                       if(piles[i] % 2== 1){
                                               result = 1;
                                       }
                               }
                               System.out.println(result);
                       }
                        
                }
                
        }
        
}
