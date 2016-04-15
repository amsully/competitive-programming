package week.eight;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringComputer164 {

        static int[][] dist = new int[22][22];
        static String x, y;
        static int N, M;

        public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                while (!(x = br.readLine()).equals("#")) {
                        y = br.readLine();
                        N = x.length();
                        M = y.length();
                        solve();
                        result();
                }
        }

        private static void solve() {
                // TODO Auto-generated method stub
                for (int i = 0; i <= N; i++)
                        dist[i][0] = i;
                for (int i = 0; i <= M; i++)
                        dist[0][i] = i;

                for (int i = 1; i <= N; i++) {
                        for (int j = 1; j <= M; j++) {
                                if (x.charAt(i-1) == y.charAt(j-1)) {
                                        dist[i][j] = dist[i - 1][j - 1];
                                } else {
                                        dist[i][j] = Math.min(dist[i - 1][j - 1],
                                                        Math.min(dist[i][j - 1], dist[i - 1][j])) + 1;
                                }
                        }
                }

        }

        private static void result() {
                int i = N, j = M;

                while ((i != 0) || (j != 0)) {
                        if (x.charAt(i - 1) == y.charAt(j - 1)) {
                                i--;
                                j--;
                                continue;
                        } else if ((j > 0) && dist[i][j] == dist[i][j - 1] + 1) { // insert
                                System.out.print("I" + y.charAt(j - 1));
                                if (i + 1 < 10)
                                        System.out.print("0");
                                System.out.print(i + 1);
                                x = x.substring(0, i) + y.charAt(j - 1) + x.substring(i);
                                j--;
                        } else if ((i > 0 && j > 0) && dist[i][j] == dist[i - 1][j - 1] + 1) {
                                System.out.print("C" + y.charAt(j - 1));
                                if (i < 10)
                                        System.out.print("0");
                                System.out.print(i);
                                x = x.substring(0, i - 1) + y.charAt(j - 1) + x.substring(i);
                                i--;
                                j--;
                        }else if(i > 0){
                                System.out.print("D");
                                System.out.print(x.charAt(i-1));
                                if(i < 10) System.out.print("0");
                                System.out.print(i);
                                x = x.substring(0,i-1)+x.substring(i+1);
                                i--;
                        }
                }
                System.out.println("E");
        }
}
