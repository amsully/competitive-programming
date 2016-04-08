package week.six;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// RUN TIME ERROR BUT CORRECT SOLUTION

class LiftHopping_10801 {

        static class Vertex {

                int floor;
                int dist;
                Vertex prev;

                public Vertex(int floor) {
                        this.floor = floor;
                        prev = null;
                        dist = Integer.MAX_VALUE;
                }
        }

        static class Edge {
                Vertex source;
                Vertex destination;
                int distance;

                public Edge(Vertex s, Vertex d, int dist) {
                        source = s;
                        destination = d;
                        distance = dist;
                }
        }

        public static void main(String[] args) throws IOException {

                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                String input;

                while ((input = br.readLine()) != null) {

                        if (input.isEmpty())
                                break;

                        ArrayList<Edge> edges = new ArrayList<Edge>();
                        ArrayList<Vertex> vertices = new ArrayList<Vertex>();

                        int e = Integer.parseInt(input.split(" ")[0]);
                        int f = 100;
                        int finishFloor = Integer.parseInt(input.split(" ")[1]);
                        String[] elevWeights = br.readLine().split(" ");

                        for (int i = 0; i < f; i++) {
                                vertices.add(new Vertex(i));
                        }

                        Vertex goalFloor = vertices.get(finishFloor);

                        for (int i = 0; i < e; i++) {
                                String[] floorsReached = br.readLine().split(" ");

                                for (int j = 0; j < floorsReached.length; j++) {
                                        for (int k = 0; k < floorsReached.length; k++) {
                                                int vert1 = Integer.parseInt(floorsReached[j]);
                                                int vert2 = Integer.parseInt(floorsReached[k]);

                                                int distance = 60 + (Math.abs(vert1 - vert2)
                                                                * Integer.parseInt(elevWeights[i]));
                                                edges.add(new Edge(vertices.get(vert1), vertices.get(vert2), distance));
                                                edges.add(new Edge(vertices.get(vert2), vertices.get(vert1), distance));

                                        }

                                }

                        }
                        // We have created all existing edges and vertices at
                        // this point

                        vertices.get(0).dist = 0;

                        while (!vertices.isEmpty()) {
                                Vertex vMin = min(vertices);
                                vertices.remove(vMin);

                                for (Edge edge : getNeighbors(vMin, edges, vertices)) {
                                        int alt = vMin.dist + edge.distance;
                                        if (alt < edge.destination.dist) {

                                                edge.destination.dist = alt;
                                                edge.destination.prev = vMin;
                                        }
                                }

                        }

                        if (goalFloor.dist == Integer.MAX_VALUE || goalFloor.dist < 0) {
                                System.out.println("IMPOSSIBLE");
                        } else {
                                if (goalFloor.dist == 0) {
                                        System.out.println(0);
                                } else {
                                        System.out.println(goalFloor.dist - 60);// First
                                        // floor
                                        // doesnt
                                        // need
                                        // to
                                        // wait
                                        // 60
                                        // seconds.
                                }

                        }
                }
                br.close();
                System.exit(0);

        }

        private static ArrayList<Edge> getNeighbors(Vertex vMin, ArrayList<Edge> es, ArrayList<Vertex> vs) {
                // TODO Auto-generated method stub
                ArrayList<Edge> ret = new ArrayList<Edge>();
                for (Edge e : es) {

                        if (e.source.equals(vMin) && vs.contains(e.destination)) {
                                ret.add(e);
                        }
                }
                return ret;
        }

        private static Vertex min(ArrayList<Vertex> vs) {
                // TODO Auto-generated method stub
                Vertex min = vs.get(0);

                for (Vertex v : vs) {
                        if (v.dist < min.dist) {
                                min = v;
                        }
                }

                return min;
        }

}