package world_codesprint_8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


/**
 * Created by ams on 12/17/16.
 */
public class RoadsAndLibraries {

        public static void main(String[] args) {


            Scanner in = new Scanner(System.in);
            int q = in.nextInt();
            for (int a0 = 0; a0 < q; a0++) {
                Graph graph = new Graph();

                int n = in.nextInt();

                for(int i = 0; i < n ;i++){
                    graph.getNode((i+1));
                }

                int m = in.nextInt();
                int buildLib = in.nextInt();
                int buildRoad = in.nextInt();
                for (int a1 = 0; a1 < m; a1++) {

                    Node city_1 = graph.getNode(in.nextInt());
                    Node city_2 = graph.getNode(in.nextInt());
                    city_1.neighbors.add(city_2);
                    city_2.neighbors.add(city_1);
                }

                if(buildLib <= buildRoad){
                    System.out.println(n * buildLib);
                }else{
                    ArrayList<Integer> components = graph.getComponents();

//                    System.out.println(components.toString());

                    long result = 0;

                    for(int componentSize : components){
                        result += (componentSize-1)*buildRoad + buildLib;
                    }
                    System.out.println(result);
                }

            }
        }
}

class Graph{
    HashMap<Integer, Node> nodes;

    public Graph(){
        nodes = new HashMap<Integer, Node>();
    }

    public Node getNode(int city){
        if(nodes.containsKey(city)) {
            return nodes.get(city);
        }else {
            Node node = new Node(city);
            nodes.put(city, node);

            return node;
        }
    }

    public ArrayList<Integer> getComponents(){
        ArrayList<Integer> components = new ArrayList<Integer>();

        for(int key : nodes.keySet()) {
            Node n = nodes.get(key);

            if(n.visited) {
                continue;
            }else {
                int componentSize = 0;

                Stack<Node> funnel = new Stack<Node>();
                funnel.add(n);

                while(!funnel.isEmpty()) {
                    Node curr = funnel.pop();

                    if(!curr.visited) {
                        componentSize++;
                        for(Node e : curr.neighbors) {
                            if(!e.visited) {
                                funnel.add(e);
                            }
                        }
                        curr.visited = true;
                    }
                }
                components.add(componentSize);

            }



        }

        return components;
    }
}

class Node{
    public Integer name;
    public ArrayList<Node> neighbors;
    public boolean visited;

    public Node(Integer name){
        this.name = name;
        this.neighbors = new ArrayList<Node>();
        this.visited = false;
    }
}
