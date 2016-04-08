package week.five;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class TransportationSystem {

        public static int[][] parent = new int[1001][2];
        public static int[][] coordinates = new int[1001][2];
        public static List<Connection> connections = new ArrayList<Connection>();

        public static void main(String[] args) throws IOException {

                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                int trials = Integer.parseInt(br.readLine());

                for (int i = 0; i < trials; i++) {

                        StringTokenizer token = new StringTokenizer(br.readLine());

                        int numberOfCities = Integer.parseInt(token.nextToken());
                        int rDist = Integer.parseInt(token.nextToken());

                        // reset all connections
                        connections.clear();

                        for (int j = 0; j < numberOfCities; j++) {

                                parent[j][0] = j;
                                parent[j][1] = 0;

                                token = new StringTokenizer(br.readLine());

                                coordinates[j][0] = Integer.parseInt(token.nextToken());
                                coordinates[j][1] = Integer.parseInt(token.nextToken());

                        }

                        // Create all connections
                        for (int j = 0; j < numberOfCities; j++) {
                                for (int k = j + 1; k < numberOfCities; k++) {
                                        double dis = calculateD(coordinates[i][0], coordinates[i][1], coordinates[j][0],
                                                        coordinates[j][1]);

                                        connections.add(new Connection(i, j, dis));

                                }
                        }

                        int stateTot = numberOfCities;

                        Collections.sort(connections);

                        double road = 0;
                        double railway = 0;

                        for (int m = 0; m < connections.size(); m++) {
                                Connection connection = connections.get(m);
                                int x = getCoor(connection.start);
                                int y = getCoor(connection.end);

                                if (x != y) {
                                        if (connection.wt > rDist) {
                                                railway += connection.wt;
                                        } else {
                                                stateTot--;
                                                road+= connection.wt;
                                        }
                                        union(x, y);
                                }
                        }
                        System.out.println("Case #"+i+":"+stateTot+" "+Math.round(road)+" " +Math.round(railway));
                }

        }

        private static void union(int x, int y) {
                // TODO Auto-generated method stub
                int startX = getCoor(x);
                int startY = getCoor(y);
                
                if(parent[startX][1] < parent[startY][1]){
                        parent[startX][0] = startY;
                }else if( parent[startX][1] > parent[startY][1]){
                        parent[startY][0]= startX;
                }else{
                        parent[startY][0] = startX;
                        parent[startX][1]++;
                }
        }

        private static int getCoor(int I) {
                // TODO Auto-generated method stub

                if (parent[I][0] != I) {
                        parent[I][0] = getCoor(parent[I][0]);
                }

                return parent[I][0];
        }

        private static double calculateD(int i, int j, int k, int l) {
                // TODO Auto-generated method stub

                return Math.sqrt(Math.pow(i - k, 2) + Math.pow(j - l, 2));

        }

        public static class Connection implements Comparable<Connection> {

                public double wt;
                public int start, end;

                public Connection(int start, int end, double wt) {
                        this.start = start;
                        this.end = end;
                        this.wt = wt;
                }

                public int compareTo(Connection secondEdge) {
                        return Double.compare(this.wt, secondEdge.wt);
                }

        }

}
