package week.six;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class NoMorePreReq_925 {

        static class Vertex implements Comparable<Vertex>{
                String name;
                int id;
                public Vertex(String name, int id){
                        this.name = name;
                        this.id = id;
                }

                @Override
                public int compareTo(Vertex o) {
                        // TODO Auto-generated method stub
                        return this.name.compareTo(o.name);
                }
        }
        
        static class Edge{
                Vertex start;
                Vertex end;
                int wt;
                
                public Edge(Vertex start, Vertex end){
                        this.start =start;
                        this.end = end;
                        this.wt = 1;
                }
                
        }
        
        public static void main(String[] args) throws IOException{
                
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                
                
                int trials = Integer.parseInt(br.readLine());
                
                for(int i = 0; i < trials; i++){
                        
                        int id = 0;
                        ArrayList<Vertex> vertices = new ArrayList<Vertex>();
                        ArrayList<Edge> edges = new ArrayList<Edge>();
                        HashMap<Integer, Vertex> map = new HashMap<Integer, Vertex>();
                        HashMap<String, Vertex> mapName = new HashMap<String, Vertex>();
                        
                        HashMap<String, ArrayList<Vertex>> adjacencyMap = new HashMap<String, ArrayList<Vertex>>();
                        
                        int courseCount = Integer.parseInt(br.readLine());
                        
                        for(int j = 0; j < courseCount; j++){

                                Vertex newVert = new Vertex(br.readLine(), id);
                                map.put(id, newVert);
                                id++;
                                mapName.put(newVert.name, newVert);
                                adjacencyMap.put(newVert.name, new ArrayList<Vertex>());
                                vertices.add(newVert);
                                
                        }
                        
                        int numberWithPreReq = Integer.parseInt(br.readLine());
                        boolean[][] skippable = new boolean[vertices.size()][vertices.size()];
                        boolean[][] reachable = new boolean[vertices.size()][vertices.size()];
                        
                        // initialize
                        for(int src= 0; src < skippable.length; src++){
                                for(int dest = 0; dest < skippable.length; dest++){
                                        skippable[src][dest] = false;
                                        reachable[src][dest] = false;
                                }
                        }
                        
                        
                        // add existing reachability
                        for(int j = 0; j < numberWithPreReq; j++){
                                String[] input = br.readLine().split(" ");
                                Vertex src = mapName.get(input[0]);
                                for(int k = 2; k < input.length; k++){
                                        edges.add(new Edge(src, mapName.get( input[k]) ) );
                                        reachable[src.id][mapName.get(input[k]).id] = true;
                                        adjacencyMap.get(src.name).add(mapName.get(input[k]));
                                }
                        }
                        
                        int[][] dist = new int[vertices.size()][vertices.size()];
                        Vertex[][] next = new Vertex[vertices.size()][vertices.size()];

                        for(Edge e : edges){

                                dist[e.start.id][e.end.id] = e.wt;
                                next[e.start.id][e.end.id] = e.end;
                        }
                        
                        for(int a = 0; a < vertices.size(); a++){
                                for( int b = 0; b < vertices.size(); b++){
                                        for(int c = 0; c < vertices.size(); c++){
//                                                if(dist[b][a] + dist[a][c] < dist[b][c]){
//                                                        dist[b][c] = dist[b][a] + dist[a][c];
//                                                        next[b][c] = next[b][a];
//                                                }
                                                if(reachable[b][a] && reachable[a][c]){
                                                        reachable[b][c] = true;
                                                }
                                        }
                                }
                        }
                        
                        HashMap<String, ArrayList<Vertex>> output = new HashMap<String, ArrayList<Vertex>>();
                        
                        for(String key : adjacencyMap.keySet()){
                                Vertex src = mapName.get(key);
                                ArrayList<Vertex> realPre = new ArrayList<Vertex>();
                                
                                for(Vertex destination : adjacencyMap.get(key)){
                                        boolean skip = false;
                                        for(Vertex otherDestination : adjacencyMap.get(key)){
                                                
                                                if( !destination.equals(otherDestination) ){
                                                        if( reachable[otherDestination.id][destination.id]){
                                                                skip = true;
                                                                break;
                                                        }
                                                }
                                                
                                        }
                                        if(!skip){
                                                realPre.add(destination);
                                        }
                                }
                                if(realPre.size() > 0){
                                        output.put(key, realPre);
                                }
                                
                        }

                        ArrayList<String> keys = new ArrayList<String>();
                        for(String res: output.keySet()){
                                keys.add(res);
                        }
                        
                        Collections.sort(keys);
                        for(String res : keys){
                                
                                int size = output.get(res).size();
                                System.out.print(res + " " + size + " ");
                                Collections.sort(output.get(res));
                                
                                int cnt = 0;
                                for(Vertex v : output.get(res)){
                                        System.out.print(v.name);
                                        if(cnt < size-1){
                                                System.out.print(" ");
                                        }
                                        cnt++;
                                }
                                System.out.println("");
                        }
                        
//                        for(int j = 0; j < vertices.size(); j++){
//                                for(int k = 0; k < vertices.size(); k++){
//                                        
//                                        printPath(j, k, vertices, next, map);
//                                        
//                                }
//                        }
                        
                }
                
                
        }

        private static void printPath(int u, int v, ArrayList<Vertex> vertices, Vertex[][] next, HashMap<Integer, Vertex > map) {
                // TODO Auto-generated method stub
                if( next[u][v] == null ) return;
                
                ArrayList<Vertex> path = new ArrayList<Vertex>();
                
                path.add(map.get(u));
                
                while( u != v ){
                        u = next[u][v].id;
                        path.add(map.get(u));
                }
                
                for(int i = 0; i < path.size(); i++){
                        System.out.print(path.get(i).name+ " " );
                }
                
                System.out.println("");
        }
}       
