package week.four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Collections;
import java.util.StringTokenizer;

public class NewStoneForfexClothGame {

        static int count;
        public static void main(String[] args) throws IOException {

                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                String scan;

                int count = 0;
                while ((scan = br.readLine()) != null) {

                        int size = Integer.parseInt(scan);
                        
                        if (scan.equals(""))
                                break;

                        int[] CSF = new int[3];
                        
                        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
                        
                        for (int i = 0; i < size; i++) {
                                String token = tokenizer.nextToken();
                                
                                if(token.equals("C")) CSF[0]++;
                                else if(token.equals("S")) CSF[1]++;
                                else if(token.equals("F")) CSF[2]++;
                                
                        }
                        
                        if(CSF[0] == size || CSF[1] == size || CSF[2] == size){
                                count = size;
                        }else if(CSF[0] != 0 && CSF[1] != 0 && CSF[2] != 0){
                                count = size;
                        }else{
                                if(CSF[0] == 0) count = CSF[1];
                                else if(CSF[1] == 0) count = CSF[2];
                                else if(CSF[2] == 0) count = CSF[0];
                        }
                                             
                        System.out.println(count);
                        count = 0;
                }
        }

}
