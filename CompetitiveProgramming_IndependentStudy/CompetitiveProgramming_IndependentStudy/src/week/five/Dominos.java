package week.five;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Dominos {

        static boolean[] vis;
        static Node[] nodes;
        static Stack<Integer> stack;
        static int N;

        public static void main(String[] args) throws IOException {

                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                int total = Integer.parseInt(br.readLine());

                while (total-- > 0) {
                        String[] input = br.readLine().split("[ ]+");
                
                        N = Integer.parseInt(input[0]);
                        int NN = Integer.parseInt(input[1]);
                        
                        nodes = new Node[N];
                        
                        for(int i = 0; i < N; ++i){
                                nodes[i] = new Node();
                        }
                        for(int i = 0; i < NN;++i){
                                input = br.readLine().split("[ ]+");
                                int start = Integer.parseInt(input[0])-1;
                                int end = Integer.parseInt(input[1])-1;
                                
                                nodes[start].adjacent.add(end);
                        }
                        System.out.println(stronglyConnectedComponents());
                        
                }
                System.exit(0);

        }

        static class Node {
                List<Integer> adjacent;

                public Node() {
                        adjacent = new ArrayList<Integer>();
                }
        }

        static void depthFirstSearch(int i) {
                vis[i] = true;

                for (int vertex : nodes[i].adjacent) {
                        if (!vis[vertex]) {
                                depthFirstSearch(vertex);
                        }
                }
                stack.push(i);
        }

        static void depthFirstSearchDontPush(int i) {
                vis[i] = true;

                for (int vertex : nodes[i].adjacent) {
                        if (!vis[vertex]) {
                                depthFirstSearchDontPush(vertex);
                        }
                }
        }

        static void topsort() {
                vis = new boolean[N];
                stack = new Stack<Integer>();

                for (int i = N - 1; i >= 0; --i) {
                        if (!vis[i]) {
                                depthFirstSearch(i);
                        }
                }

        }

        static int stronglyConnectedComponents() {
                topsort();
                vis = new boolean[N];

                int componentCount = 0;

                while (!stack.isEmpty()) {
                        int x = stack.pop();
                        if (!vis[x]) {
                                ++componentCount;
                                depthFirstSearchDontPush(x);
                        }
                }
                return componentCount;
        }

}
