package week.seven;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DataFlow_10594 {

        static class Edge {
                int u;
                int v;
                int cost;
                int capacity;
                int next;

                Edge(int u, int v, int cost, int capacity) {
                        this.u = u;
                        this.v = v;
                        this.cost = cost;
                        this.capacity = capacity;
                        this.next = first[u];
                        first[u] = edgenum;
                        edgenum++;
                }
        }

        static int numberOfNodes;
        static int numberOfEdges;

        static int source;
        static int sink;

        static int[] u;
        static int[] v;
        static int[] cost;
        static int[] first = new int[102];
        static int[] parent = new int[102];
        static double[] dist;
        static int tData;
        static int capacity;
        static int edgenum;
        static int totCost;

        static ArrayList<Edge> edges = new ArrayList<Edge>();

        public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                String begin;

                while ((begin = br.readLine()) != null) {
                        if(begin.isEmpty())break;
                        edges.clear();
                        numberOfNodes = Integer.parseInt(begin.split(" ")[0]);
                        numberOfEdges = Integer.parseInt(begin.split(" ")[1]);

                        u = new int[numberOfEdges * 4];
                        v = new int[numberOfEdges * 4];
                        cost = new int[numberOfEdges * 4];
                        first = new int[numberOfEdges * 4]; Arrays.fill(first, -1);
                        dist = new double[numberOfNodes + 2];

                        for (int i = 0; i < numberOfEdges; i++) {
                                String edge = br.readLine();
                                StringTokenizer strTkn = new StringTokenizer(edge);
                                u[i] = Integer.parseInt(strTkn.nextToken());
                                v[i] = Integer.parseInt(strTkn.nextToken());
                                cost[i] = Integer.parseInt(strTkn.nextToken());
                        }
                        String end = br.readLine();
                        tData = Integer.parseInt(end.split(" ")[0]);
                        capacity = Integer.parseInt(end.split(" ")[1]);
                        edgenum = 0;
                        for (int i = 0; i < numberOfEdges; i++) {
                                edges.add(new Edge(u[i], v[i], cost[i], capacity));
                                edges.add(new Edge(v[i], u[i], -cost[i], 0));
                                edges.add(new Edge(v[i], u[i], cost[i], capacity));
                                edges.add(new Edge(u[i], v[i], -cost[i], 0));
                                // TODO ADD THE REST OF THE EDGES
                        }

                        edges.add(new Edge(0, 1, 0, tData));
                        edges.add(new Edge(1, 0, 0, 0));

                        source = 0;
                        sink = numberOfNodes;

                        long res = minCostMaxFlow(numberOfNodes);

                        if (res == tData) {
                                System.out.println(totCost);
                        } else {
                                System.out.println("Impossible.");
                        }
                }

        }

        private static long minCostMaxFlow(int sink2) {
                // TODO Auto-generated method stub
                long F = 0, mn;
                totCost = 0;

                while (true) {

                        shortestPathFasterAlgorithm(numberOfNodes);

                        if (dist[sink] == Long.MAX_VALUE) {
                                break;
                        }
                        mn = Long.MAX_VALUE;
                        for(int k = parent[sink]; k != -1; k = parent[edges.get(k).u]){
                                mn = Math.min(mn, edges.get(k).capacity);
                        }
                        for(int k = parent[sink]; k != -1; k = parent[edges.get(k).u]){
                                edges.get(k).capacity -= mn;
                                edges.get(k^1).capacity += mn;
                        }
                        F += mn;
                        totCost += mn * dist[sink];
                        
                        
                }
                return F;
        }

        private static void shortestPathFasterAlgorithm(int numberOfNodes2) {
                // TODO Auto-generated method stub

                Queue<Integer> q = new LinkedList<Integer>();
                int[] visited = new int[numberOfNodes2 + 2];
                Arrays.fill(visited, 0);
                Arrays.fill(dist, Long.MAX_VALUE);
                Arrays.fill(parent, -1);

                dist[source] = 0;
                visited[source] = 1;

                q.add(source);

                while (!q.isEmpty()) {
                        int u = q.poll();
                        visited[u] = 0;

                        for (int k = first[u]; k != -1; k = edges.get(k).next) {
                                
                                int v = edges.get(k).v;

                                if ((edges.get(k).capacity > 0) && (dist[u] + edges.get(k).cost) < dist[v]) {
                                        parent[v] = k;
                                        dist[v] = dist[u] + edges.get(k).cost;
                                        if (visited[v] == 0) {
                                                visited[v] = 1;
                                                q.add(v);
                                        }
                                }

                        }

                }
                return;
        }

}
