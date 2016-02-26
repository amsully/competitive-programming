package week.three;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class RussianDolls_10549_Naive {

        public static void main(String[] args) throws IOException {

                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                String numberOfDolls;

                LinkedList<RussianDoll> dolls = new LinkedList<RussianDoll>();

                while (true) {

                        dolls.clear();
                        
                        numberOfDolls = br.readLine();
                        int setSize = (Integer.parseInt(numberOfDolls));
                        System.out.println(numberOfDolls);
                        if (numberOfDolls.equals("0"))
                                break;

                        int numDolls = Integer.parseInt(numberOfDolls);

                        int totDolls = numDolls * 2;

                        for (int i = 0; i < totDolls; i++) {

                                StringTokenizer tk = new StringTokenizer(br.readLine());

                                int h = Integer.parseInt(tk.nextToken());
                                int d = Integer.parseInt(tk.nextToken());
                                int w = Integer.parseInt(tk.nextToken());

                                dolls.add(new RussianDoll(h, d, w));

                        }
                        
                        Collections.sort(dolls);

                        for(RussianDoll d: dolls) d.print();

                        
                        LinkedList<RussianDoll> set1 = new LinkedList<RussianDoll>();
                        
                        set1.add(dolls.remove());// Append smallest doll to list.
                        
                        Iterator<RussianDoll> itr = dolls.iterator();
                        
                        
                        
                        RussianDoll curr;
                        while(itr.hasNext()){
                                
                                curr = itr.next();
                                
                                curr.print();
                                set1.getLast().print();
                                System.out.println( curr.compareTo(set1.getLast() ) );
                                
                                if(curr.compareTo( set1.getLast()) > 0){
                                        set1.add(curr);
                                        itr.remove();
                                }
                                
                                if( set1.size() == setSize ) break;
                                 
                        }
                        
                        Comparator<RussianDoll> c = new Comparator<RussianDoll>() {

                                @Override
                                public int compare(RussianDoll o1, RussianDoll o2) {
                                        // TODO Auto-generated method stub
                                        return o2.height - o1.height ;
                                }
                                
                                
                        };
                        
                        Collections.sort(dolls, c);
                        Collections.sort(set1, c);
                    
                        System.out.println("OUTPUT");
                        for(RussianDoll d: dolls) d.print();
                        System.out.println("-");
                        for(RussianDoll d : set1) d.print();

                }



        }

}

class RussianDoll implements Comparable<RussianDoll> {

        int height;
        int width;
        int diameter;

        int diameterFit;
        int heightFit;

        RussianDoll(int h, int d, int w) {
                height = h;
                width = w;
                diameter = d;
                diameterFit = d - (2 * w);
                heightFit = h - (2 * w);
        }

        void printFit() {
                System.out.println("Height: " + heightFit + " Width: " + diameterFit);
        }
        
        void print(){
                System.out.println(height + " " + diameter + " " + width);
        }

//        public int compareTo(RussianDoll rd) {
//
//                if (this.diameterFit == rd.diameterFit && this.heightFit == rd.heightFit) {
//                        return 0;
//                }
//                if (this.diameterFit < rd.diameterFit && this.heightFit < rd.heightFit) {
//                        return -1;
//                } else {
//                        return 1;
//                }
//        }
        
        public int compareTo(RussianDoll rd) {

                if (this.diameterFit >= rd.diameter && this.heightFit > rd.height) {
                        return 1;
                }if( rd.diameterFit >= this.diameter && rd.heightFit > this.height ){
                        return -1;
                }else{
                        return 0;
                }
        }
        
        
//        public int compareTo(RussianDoll rd) {
//
//                if (this.diameterFit < rd.diameter && this.heightFit < rd.height) {
//                        return -1;
//                } else {
//                        return 1;
//                }
//        }
        
        
}
