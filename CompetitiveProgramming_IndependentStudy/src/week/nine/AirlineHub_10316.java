package week.nine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AirlineHub_10316 {

        static double R = 6378;
        static double PI = Math.acos(-1);

        public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                double[] x = new double[1005], y = new double[10005], z = new double[1005];
                double[] W = new double[1005], THETA = new double[1005];
                int i, j, k;
                double w, theta;

                String n;
                while ((n = br.readLine()) != null) {
                        if (n.isEmpty())
                                return;

                        for (i = 0; i < Integer.parseInt(n); i++) {
                                String line = br.readLine();
                                W[i] = Double.parseDouble(line.split(" ")[0]);
                                THETA[i] = Double.parseDouble(line.split(" ")[1]);

                                w = W[i] * PI / 180.0;
                                theta = THETA[i] * PI / 180.0;
                                x[i] = R * Math.cos(w) * Math.sin(theta);
                                y[i] = R * Math.cos(w) * Math.cos(theta);
                                z[i] = R * Math.sin(theta);
                        }
                        double mx, mn = Double.MAX_VALUE;
                        double rx = W[0], ry = THETA[0];

                        for (i = 0; i < Integer.parseInt(n); i++) {
                                mx = 0;
                                
                                for(j = 0; j < Integer.parseInt(n); j++){
                                        if(i == j) continue;
                                        
                                        double ab = Math.sqrt(Math.pow(x[i]-x[j], 2) + Math.pow(z[i] -z[j],2));
                                        double oa = R, ob =R;
                                        theta = Math.acos(oa*oa+ob*ob- ab*ab/2*oa*ob);
                                        mx = Math.max(mx, R*theta);
                                        if(mx> mn + 0.0000001) break;
                                }
                                
                                if(mn >= mx - 0.0000001){
                                        mn = mx;
                                        rx = W[i];
                                        ry = THETA[i];
                                }
                        }
                        System.out.println(rx + " " + ry);
                }

        }

}
