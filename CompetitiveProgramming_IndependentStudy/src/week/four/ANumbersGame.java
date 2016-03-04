package week.four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

// Theory: store all values? 

public class ANumbersGame {

        static ArrayList<ArrayList<ArrayList<Integer>>> allSets;        
        
        public static void main(String[] args ) throws IOException{
                
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                
                allSets = new ArrayList<ArrayList<ArrayList<Integer>>>();
                
                createSets();
                
                String scan;
                
                while( (scan = br.readLine()) != null){
                        if(scan.equals("0")) break;
                        
                       StringTokenizer tokenizer = new StringTokenizer(scan);
                       
                       int size = Integer.parseInt(tokenizer.nextToken());
                       
                       HashSet<Integer> givenSet = new HashSet<Integer>();
                       
                       for(int i = 0; i < size; i++)
                       {
                               givenSet.add(Integer.parseInt(tokenizer.nextToken()));
                       }
                       
                       calculateAllWinnsers(givenSet);
                }
                
        }

        private static void calculateAllWinnsers(HashSet<Integer> givenSet) {
                
                LinkedList<Integer> answerSet = new LinkedList<Integer>();
                Iterator<Integer> itr = givenSet.iterator();
                
                while(itr.hasNext()){
                        int choice = itr.next();
                        
                        HashSet<Integer> newSet = (HashSet<Integer>) givenSet.clone();
                        
                        newSet.remove(choice);
                        
                        if( isWinningChoice(newSet,0) ){
                                newSet.add(choice);
                        }
                        
                }
                
                System.out.println( answerSet.toString() );
                
                
        }

        @SuppressWarnings("unchecked")
        private static boolean isWinningChoice(HashSet<Integer> newSet, int i) {
                // TODO Auto-generated method stub
                
                if(newSet.size() == 0){
                        if(i%2 == 0) return false;
                        else return true;
                }
                
                Iterator<Integer> itr = newSet.iterator();
                
                boolean result = true;
                
                while(itr.hasNext()){
                        HashSet<Integer> newChoiceSet = (HashSet<Integer>) newSet.clone();
                        
                        int choice = itr.next();
                        
                        newChoiceSet.remove(choice);
                        
                        // Remove all extra values.
                        for(int j = 0; j < 20; j++){
                                ArrayList<Integer> valsToRemove = allSets.get(i).get(choice);
                                
                                Iterator<Integer> itrRemoval = valsToRemove.iterator();
                                while(itrRemoval.hasNext()){
                                        newChoiceSet.remove(itrRemoval.next());
                                }
                        }
                        
                        result |= isWinningChoice(newChoiceSet, i++);
                        
                }
                
                return result;
        }

        private static void createSets() {
                // TODO Auto-generated method stub
                
                for(int i = 0; i < 20; i++){
                        allSets.add(new ArrayList<ArrayList<Integer>>());
                        for(int j = 0; j < 20; j++){
                                allSets.get(i).add(new ArrayList<Integer>());
                                
                                for(int jMult = 0; jMult <= 20; jMult++){
                                        for(int iMult = 0; iMult <= 20; iMult++){
                                                
                                                if((jMult*j)+(iMult*i) <= 20){
                                                        allSets.get(i).get(j).add((jMult*j)+(iMult*i));
                                                }
                                        }
                                }
                        }
                }
        }
        
}
