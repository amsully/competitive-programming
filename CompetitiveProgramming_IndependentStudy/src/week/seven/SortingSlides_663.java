package week.seven;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;

public class SortingSlides_663 {

        static class Letter {
                char letter;
                int xMin, xMax, yMin, yMax;

                public Letter(char letter, int xMin, int xMax, int yMin, int yMax) {
                        this.letter = letter;
                        this.xMin = xMin;
                        this.xMax = xMax;
                        this.yMin = yMin;
                        this.yMax = yMax;
                }

                public boolean contains(Number num) {

                        return (num.x < xMax && num.x > xMin && num.y < yMax && num.y > yMin);
                }

        }

        static class Number {
                int number;
                int x, y;

                public Number(int number, int x, int y) {
                        this.number = number;
                        this.x = x;
                        this.y = y;
                }
        }

        static class Edge implements Comparable<Edge> {
                Number number;
                Letter letter;
                boolean removed;

                public Edge(Number number, Letter letter) {
                        this.number = number;
                        this.letter = letter;
                        removed = false;
                }

                public String toString() {
                        return ("(" + letter.letter + "," + number.number + ")");
                }

                @Override
                public int compareTo(Edge arg0) {
                        // TODO Auto-generated method stub
                        return this.letter.letter - arg0.letter.letter;
                }

        }

        static ArrayList<Letter> letters = new ArrayList<Letter>();
        static ArrayList<Number> numbers = new ArrayList<Number>();
        static LinkedList<Edge> edges = new LinkedList<Edge>();
        static int numberOfEdges = 0;
        static ArrayList<Edge> result = new ArrayList<Edge>();

        public static void main(String[] args) throws IOException {

                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                ArrayList<ArrayList<Edge>> output = new ArrayList<ArrayList<Edge>>();
                
                String in;
                int heap = 0;
                while ((in = br.readLine()) != null) {
                        if (in.isEmpty())
                                break;

                        int n = Integer.parseInt(in);
                        if (n == 0)
                                break;
                        heap++;
                        // Reset
                        letters.clear();
                        numbers.clear();
                        edges.clear();
                        numberOfEdges = 0;

                        for (int i = 0; i < n; i++) {
                                String[] inletters = br.readLine().split(" ");

                                letters.add(new Letter((char) ('A' + i), Integer.parseInt(inletters[0]),
                                                Integer.parseInt(inletters[1]), Integer.parseInt(inletters[2]),
                                                Integer.parseInt(inletters[3])));
                        }
                        for (int i = 0; i < n; i++) {
                                // TODO +1 !!

                                String[] inNumbers = br.readLine().split(" ");
                                Number newNum = new Number(i + 1, Integer.parseInt(inNumbers[0]),
                                                Integer.parseInt(inNumbers[1]));

                                for (Letter l : letters) {
                                        if (l.contains(newNum)) {
                                                edges.add(new Edge(newNum, l));
                                                numberOfEdges++;
                                        }
                                }
                        }

                        // for(Edge e : edges){
                        // System.out.println(e.toString());
                        // }

                        int loopCount = 0;
                        boolean print = true;
                        while (numberOfEdges > 0) {
                                loopCount++;
                                if (loopCount > numberOfEdges) {
                                        output.add(new ArrayList<Edge>());
//                                        System.out.println("Heap " + heap);
//                                        System.out.println("none");
//                                        System.out.println("");
                                        print = false;
                                        break;
                                }
                                Edge curr = edges.poll();

                                HashSet<Character> set = new HashSet<Character>();
                                HashSet<Edge> removeSet = new HashSet<Edge>();

                                for (Edge e : edges) {

                                        set.add(e.letter.letter);
                                        if (e.number.number == curr.number.number) {
                                                removeSet.add(e);

                                        }

                                }

                                if (!set.isEmpty() && set.contains(curr.letter.letter)) {
                                        edges.add(curr);
                                } else {
                                        loopCount = 0;
                                        numberOfEdges--;
                                        for (Edge e : removeSet) {
                                                numberOfEdges--;
                                                edges.remove(e);
                                        }

                                        result.add(curr);
                                }

                        }

                        if (print) {
                                Collections.sort(result);

                                output.add( (ArrayList<Edge>) result.clone());
//                                System.out.println("Heap " + heap);
//                                int count = 1;
//                                for (Edge e : result) {
//                                        if (count == result.size()) {
//                                                System.out.println(e.toString());
//                                        } else {
//                                                System.out.print(e.toString() + " ");
//                                        }
//                                        count++;
//
//                                }
//                                System.out.println("");
                        }
                }
                
                int i = 0;
                for(ArrayList<Edge> out : output){
                        i++;
                        System.out.println("Heap " + i);
                        
                        if(out.isEmpty()){
                                System.out.println("none");
                        }else{
                                int count = 1;
                                for (Edge e : out) {
                                        if (count == result.size()) {
                                                System.out.println(e.toString());
                                        } else {
                                                System.out.print(e.toString() + " ");
                                        }
                                        count++;

                                }
                        }
                        if( i != output.size() ){
                                System.out.println("");
                        }
                }

        }

}
