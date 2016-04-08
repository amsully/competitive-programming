package week.seven;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class SortingSlides_663 {

        static class Letter{
                char letter;
                int xMin, xMax, yMin, yMax;
                public Letter(char letter, int xMin, int xMax, int yMin, int yMax){
                        this.letter = letter;
                        this.xMin = xMin;
                        this.xMax = xMax;
                        this.yMin = yMin;
                        this.yMax = yMax;
                }
                
                public boolean contains(Number num){
                        
                        return(num.x < xMax && num.x > xMin && num.y < yMax && num.y > yMin);
                }
                
        }
        
        static class Number{
                int number;
                int x,y;
                
                public Number(int number, int x, int y){
                        this.number = number;
                        this.x = x;
                        this.y = y;
                }
        }
        
        static class Edge{
                Number number;
                Letter letter;
                
                public Edge(Number number, Letter letter){
                        this.number = number;
                        this.letter = letter;
                }
                
                public String toString(){
                        return ("("+letter.letter+","+number.number+")");
                }
                
        }
        
        static ArrayList<Letter> letters = new ArrayList<Letter>();
        static ArrayList<Number> numbers = new ArrayList<Number>();
        static ArrayList<Edge> edges = new ArrayList<Edge>();
        static int numberOfEdges = 0;
        static ArrayList<Edge> result = new ArrayList<Edge>();
        
        public static void main(String[] args) throws IOException{
        
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                
                String in;
                
                while((in = br.readLine()) != null){
                       if(in.isEmpty())break;
                       
                       int n = Integer.parseInt(in);
                       
                       /*
                        * TODO : CHANGE READ TO READLINE. IT READS ***** chars
                        */
                       
                       
                       
                        System.out.println(n);
                        // Reset
                        letters.clear();
                        numbers.clear();
                        edges.clear();
                        numberOfEdges = 0;
                        
                        for(int i = 0; i < n; i++){
                                System.out.println("HERE");

                                letters.add(new Letter((char) ('A'+i),br.read(), br.read(), br.read(), br.read()));
                        }
                        for(int i = 0; i < n; i++){
                                // TODO +1 !!
                                Number newNum = new Number(i+1, br.read(), br.read());

                                for(Letter l : letters){
                                        if(l.contains(newNum)){
                                                edges.add(new Edge(newNum, l));
                                                numberOfEdges++;
                                        }
                                }
                        }
                        
                        while(numberOfEdges > 0){
                                Edge curr = edges.get(0);
                                edges.remove(0);
                                HashSet<Letter> set = new HashSet<Letter>();
                                
                                for(Edge e : edges){
                                        
                                        set.add(e.letter);
                                        
                                }
                                
                                if(set.contains(curr.letter)){
                                        edges.add(curr);
                                }else{
                                        result.add(curr);
                                }
                                
                        }
                        
                        for(Edge e : result){
                                System.out.println("Heap " + n);
                                System.out.println(e.toString());
                        }
                }
                
        }
        
        
        
}
