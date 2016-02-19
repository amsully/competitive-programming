package week.two;

/*
 * ACCEPTED
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FleaCircus_10938 {
        
        
        public static void main(String[] args) throws IOException{
                
                BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
                
                while(true){
                        
                        int n = Integer.parseInt(br.readLine());
                        
                        if(n == 0) break;
                        
                        ArrayList<ArrayList<Integer>> tree = new ArrayList<ArrayList<Integer>>(n);
                        
                        for(int i = 0 ; i < n; i++){
                                tree.add(new ArrayList<Integer>());
                        }
                        
                        for(int i =  0; i < n - 1; i++){
                                String s = br.readLine();
                                String[] sArr = s.split(" ");
                                int node1 = Integer.parseInt(sArr[0]) -1;
                                int node2 = Integer.parseInt(sArr[1]) -1;
                                
                                tree.get(node2).add(node1);
                                tree.get(node1).add(node2);
                        }
                        
                        int l = Integer.parseInt(br.readLine());
                        
                        for(int i = 0; i < l; i++){
                                String s = br.readLine();
                                String[] sArr = s.split(" ");
                                
                                int flea1 = Integer.parseInt(sArr[0]) - 1; // Account for indexing
                                int flea2 = Integer.parseInt(sArr[1]) - 1;
                                
                                ArrayList<Integer> pathToFleas = breadthFirstSearch(flea1, flea2, n, tree);
                                
                                if(pathToFleas.size() %2 == 1){
                                        int val = pathToFleas.get(pathToFleas.size()/2) +1;
                                        System.out.println("The fleas meet at " + val + ".");
                                }else if(pathToFleas.size() > 0){

                                        int val1 = pathToFleas.get((pathToFleas.size() - 1) / 2);
                                        int val2 = pathToFleas.get((pathToFleas.size() - 1) / 2 + 1); 
                                        

                                        
                                        System.out.println("The fleas jump forever between " + (Math.min(val1, val2)+1) + " and " + (Math.max(val1, val2)+1) +"." );

                                        
                                }else{
                                        System.out.println("The fleas meet at " + (flea1 + 1) + ".");
                                }
                        }
                        
                }
                
        }

        private static ArrayList<Integer> breadthFirstSearch(int flea1, int flea2, int n, ArrayList<ArrayList<Integer>> t) {
                // TODO Auto-generated method stub
                Queue<Integer> visitedQueue = new LinkedList<Integer>();
                int[] path = new int[n];
                Arrays.fill(path, -1);
                
                
                boolean[] visited = new boolean[n];
                
                visited[flea1] = true;
                visitedQueue.offer(flea1);
                
                while(!visitedQueue.isEmpty()){
                        int val = visitedQueue.poll();
                        
                        if(val == flea2) break;
                        
                        for(int neighbor: t.get(val)){
                                if(!visited[neighbor]){
                                        visited[neighbor] = true;
                                        path[neighbor] = val;
                                        visitedQueue.offer(neighbor);
                                }
                        }

                }
                
                
                ArrayList<Integer> arrPath = new ArrayList<Integer>();
                int cur = flea2;
                while(cur != -1){
                        arrPath.add(cur);
                        cur = path[cur];
                }
                return arrPath;
        }
        
}
