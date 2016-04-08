package week.three;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 
 * @author ams
 * 
 * 
 */

public class ApplemanAndTree_codeforces {

        public static void main(String[] args) throws Exception{
                
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                
                int numberOfTrees = Integer.parseInt(br.readLine());
                
                int[] colors = new int[numberOfTrees];
                ArrayList<ArrayList<Integer>> tree = new ArrayList<ArrayList<Integer>>();
                
                for(int i =0; i < numberOfTrees; i++){
                        tree.add(new ArrayList<Integer>());
                }
                
                String line = br.readLine();
                
                String[] str = line.split(" " );
                
                for(int i = 0; i < str.length; i++){
                        
                        int val = Integer.parseInt(str[i]);
                        
                        tree.get(i+1).add(val);
                        
                        
                }
                
                solve(tree, colors);
                
        }
        
        static int solve(ArrayList<ArrayList<Integer>> tree, int[] colors){
                
                
                
                return 0;
        }
        
}
