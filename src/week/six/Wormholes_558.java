package week.six;

import java.util.*;

// ACCEPTED

public class Wormholes_558 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int cases = Integer.parseInt(scan.nextLine());
        for (int _ = 0; _ < cases; _++) {
            String[] in1 = scan.nextLine().split(" ");
            int n = Integer.parseInt(in1[0]);
            int m = Integer.parseInt(in1[1]);
            int[] from = new int[m];
            int[] to = new int[m];
            int[] weights = new int[m];
            int[] dist = new int[n];
            for (int i = 1; i < n; i++) {
                dist[i] = 1000000;
            }
            for (int i = 0; i < m; i++) {
                String[] in2 = scan.nextLine().split(" ");
                from[i] = Integer.parseInt(in2[0]);
                to[i] = Integer.parseInt(in2[1]);
                weights[i] = Integer.parseInt(in2[2]);
            }

            for (int i = 0; i < m; i++) {
                for (int x = 0; x < to.length; x++) {
                    int u = from[x];
                    int v = to[x];
                    int w = weights[x];
                    if (dist[u] + w < dist[v]) {
                        dist[v] = dist[u] + w;
                    }
                }
            }
            boolean flag = false;
            for (int x = 0; x < to.length; x++) {
                int u = from[x];
                int v = to[x];
                int w = weights[x];
                if (dist[u] + w < dist[v]) {
                    System.out.println("possible");
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                System.out.println("not possible");
            }

        }

        scan.close();
    }
}
