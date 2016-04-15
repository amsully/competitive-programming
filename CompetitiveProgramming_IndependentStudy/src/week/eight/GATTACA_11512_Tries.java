package week.eight;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GATTACA_11512_Tries {

        static String let = "ACGT";
        
        public static void main(String[] args) throws IOException{
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                
                for(int T = Integer.parseInt(br.readLine()), c=0; c < T; c++){
                        String s= br.readLine();
                        
                        int n = s.length(), rep = 0;
                        
                        String ans = "";
                        Node root = new Node();
                        for(int i  = 0; i < n ; ++i){
                                Node foot = root;
                                String sf = "";
                                for(int j = i; j < n; ++j){
                                        sf = s.substring(i,j);
                                        int v = let.indexOf(s.charAt(j));
                                        if(foot.sons[v] == null) foot.sons[v] = new Node();
                                        foot = foot.sons[v];
                                        int t = ++foot.info;
                                        if(t > 1 && (sf.length() > ans.length() || (sf.length() == ans.length() && sf.compareTo(ans)<0))){
                                                ans = sf;
                                                rep = t;
                                        }
                                }
                        }
                        System.out.println(ans.length()==0? "No repetitions found!":(ans + " " + rep));
                }
        }
}

class Node{
        int info;
        Node sons[];
        Node(){
                info = 0;
                sons = new Node[4];
        }
}
