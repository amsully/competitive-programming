package week.three;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class RussianDolls_10549 {

        static class RussianDoll {
                int height, diameter, width;

                public RussianDoll(int h, int d, int w) {
                        height = h;
                        diameter = d;
                        width = w;
                }

                boolean fit(RussianDoll rd) {
                        int diamterFit = rd.diameter - 2 * rd.width;
                        int heightFit = rd.height - 2 * rd.width;

                        return (heightFit >= height) && (diamterFit >= diamterFit);
                }

                public String toString() {
                        return height + " " + diameter + " " + width;
                }

        }

        static RussianDoll[] dolls;
        static boolean[] visited;
        static Stack<RussianDoll> topologicalSort;
        static byte[][][] dp;
        static int[][][] next;
        static int n;

        public static void depthFirstSearch(int i) {
                if (!visited[i]) {
                        visited[i] = true;

                        for (int j = 0; j < dolls.length; j++) {
                                if (dolls[i].fit(dolls[j])) {
                                        depthFirstSearch(j);
                                }
                        }
                        topologicalSort.push(dolls[i]);

                }
        }

        public static byte run(int i, int j, int ci) {
                if(dp[i+1][j+1][ci] != -1){
                        return dp[i+1][j+1][ci];
                }
                
                int nxt = Math.max(i, j) +1;
                if(nxt  == n  && ci ==n /2){
                        return 1;
                }else if( nxt  == n)
                        return 0;
                
                byte res= 0;
                int cj = nxt  - ci;
                
                if(ci < n /2 && i == -1 || (dolls[i].fit(dolls[nxt ]))){
                        res = run(nxt , j, ci+1);
                }
                if(res == 1){
                        next[i+1][j+1][ci] = 0;
                        return dp[i+1][j+1][ci] =res;
                }
                
                if (cj < n / 2 && j == -1 || (dolls[j].fit(dolls[nxt])))
                        res = run(i, nxt, ci);
                if( res == 1){
                        next[i+1][j+1][ci] = 1;
                        return dp[i+1][j+1][ci] = 1;
                }
                
                return dp[i + 1][j + 1][ci];
        }

        public static void main(String[] args) throws Exception{
                
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                
                int c = 0; 
                
                while(true){
                        n = 2 * Integer.parseInt(br.readLine());
                        
                        if(n == 0) break;
                        if(c != 0) System.out.println();
                        
                        c = 1;
                        
                        dolls = new RussianDoll[n];
                        
                        visited = new boolean[n];
                        
                        topologicalSort = new Stack<RussianDoll>();

                        for(int i = 0; i < n; i ++){
                                String input = br.readLine();
                                String[] vals = input.split(" " );
                                
                                dolls[i] = new RussianDoll(Integer.parseInt(vals[0]), Integer.parseInt(vals[1]), Integer.parseInt(vals[2]));                                
                        }
                        
                        for(int i = 0; i < n; i++){
                                depthFirstSearch(i);
                        }
                        
                        for(int i = 0; i < dolls.length; i++){
                                dolls[i] = topologicalSort.pop();
                        }
                        
                        dp = new byte[n+2][n+2][n+1];
                        next = new int[n+2][n+2][n+1];
                        
                        for(int i =0; i < dp.length; i++){
                                for(int j = 0; j < dp.length; j++){
                                        for(int k = 0; k < n; k++){
                                                dp[i][j][k] = -1;
                                        }
                                }
                        }
                        
                        Stack<RussianDoll> first = new Stack<RussianDoll>();
                        Stack<RussianDoll> second = new Stack<RussianDoll>();
                        
                        run(-1,-1,0);
                        
                        int i = -1;
                        int j = -1; 
                        int ni = 0;
                        
                        while(true){
                                int nx = Math.max(i, j) +1;
                                
                                if(nx ==n) break;
                                if(next[i+1][j+1][ni] == 0){
                                        i = nx;
                                        ni++;
                                        first.push(dolls[nx]);
                                }else{
                                        j = nx; 
                                        second.push(dolls[nx]);
                                }
                        }
                        
                        while(!first.isEmpty()){
                                System.out.println(first.pop());
                        }
                        System.out.println("-");
                        while(!second.isEmpty()){
                                System.out.println(second.pop());
                        }
                }
                

                
        }

}
