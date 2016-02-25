package week.three;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class RussianDolls_10549 {

        public static void main(String[] args) throws IOException{
                
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                
                String numberOfDolls;
                
                ArrayList<RussianDoll> dolls = new ArrayList<RussianDoll>();
                
                while( true ){

                        numberOfDolls = br.readLine();
                        System.out.println(numberOfDolls);
                        if(numberOfDolls.equals("0")) break;
                        
                        int numDolls = Integer.parseInt(numberOfDolls);
                        
                        int totDolls = numDolls*2;
                        
                        for(int i = 0; i < totDolls; i++){
                                
                                StringTokenizer tk = new StringTokenizer(br.readLine());
                                
                                int h = Integer.parseInt(tk.nextToken());
                                int d = Integer.parseInt(tk.nextToken());
                                int w = Integer.parseInt(tk.nextToken());
                                
                                dolls.add(new RussianDoll(h,d,w));
                                
                        }
                        
                }
                
                for(RussianDoll d : dolls) d.printFit();
                
        }
        
}

class RussianDoll{
        
        int height;
        int width;
        int diameter;
        
        int diameterFit;
        int heightFit;
        
        RussianDoll(int h, int d, int w){
                height = h;
                width = w;
                diameter = d;
                diameterFit = d - (2*w);
                heightFit = h - (2*w);
        }
        
        void printFit(){
                System.out.println("Height: " + heightFit + " Width: " + diameterFit);
        }
        
}

