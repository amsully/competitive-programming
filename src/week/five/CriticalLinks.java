package week.five;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class CriticalLinks {

        public static HashMap<Integer, List<Integer>> adjacent = new HashMap<Integer, List<Integer>>();
        public static HashSet<Integer> vis = new HashSet<Integer>();
        public static HashMap<Integer, Integer> disconnects = new HashMap<Integer, Integer>();
        public static HashMap<Integer, Integer> low = new HashMap<Integer, Integer>();
        public static HashMap<Integer, Integer> parent = new HashMap<Integer, Integer>();
        
        
        public static int time = 0;
        

        public static void main(String[] args) throws IOException{
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String next = null;
                
                while((next = br.readLine()) != null){
                        if(next.equals("") ) break;
                        int n = Integer.valueOf(next);
                        
                        adjacent.clear();
                        bridge.clear();
                        vis.clear();
                        parent.clear();
                        low.clear();
                        
                        for(int i = 0; i < n; i++){
                                adjacent.put(i,  new ArrayList<Integer>());
                        }
                        
                        for(int i = 0; i < n ; i++){
                                disconnects.put(i,  0);
                                parent.put(i, -1);
                                low.put(i, 0);
                                
                                StringTokenizer token = new StringTokenizer(br.readLine());
                                int vertex = Integer.valueOf(token.nextToken().replace("(", "").replace(")", ""));
                                
                                while(token.hasMoreTokens()){
                                        int adj= Integer.valueOf(token.nextToken().replace("(", "").replace(")", ""));
                                        // Bidirectional
                                        adjacent.get(vertex).add(adj);
                                        adjacent.get(adj).add(vertex);
                                }
                                
                        }
                        
                        for(int i = 0; i < n; i++){
                                solve(i);
                        }
                        
                        System.out.println(bridge.size() + " critical links");
                        
                        while(bridge.size() > 0){
                                Connection temp = bridge.poll();
                                System.out.println(temp.a + " - " + temp.b);
                        }
                        System.out.println();
                        
                        
                }
        }
        
        private static void solve(int i) {
                // TODO Auto-generated method stub
                vis.add(i);
                
                ++time;
                disconnects.put(i, time);
                low.put(i,  time);
                
                List<Integer> adj = adjacent.get(i);
                
                if(adj != null){
                        for(Integer adjV : adj){
                                if(!vis.contains(adjV)){
                                        parent.put(adjV, i);
                                        solve(adjV);
                                        
                                        low.put(i, Math.min(low.get(i), low.get(adjV)));
                                        
                                        if(low.get(adjV) > disconnects.get(i)){
                                                if(i < adjV){
                                                        bridge.add(new Connection(i, adjV));
                                                }else{
                                                        bridge.add(new Connection(adjV, i));
                                                }
                                        }
                                        
                                }else if(adjV != parent.get(i)){
                                        low.put(i, Math.min(low.get(i), disconnects.get(adjV)));
                                }
                        }
                }
        }

        public static class Compar implements Comparator<Connection> {
                public int compare(Connection x, Connection y) {
                        if (x.a != y.a) {
                                return x.a - y.a;
                        } else {
                                return x.b - y.b;
                        }
                }
        }

        public static class Connection {
                public int a, b;

                public Connection(int a, int b) {
                        this.a = a;
                        this.b = b;
                }
        }

        public static PriorityQueue<Connection> bridge = new PriorityQueue<Connection>(10, new Compar());
        
}
