package week.three;

/**
 * Not use bit mask yet
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class HIST2_Histogram_SPOJ {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int number = Integer.parseInt(br.readLine());

            if (number == 0) break;

            String line = br.readLine();
            String[] str = line.split(" ");

            int[] input = new int[number];

            for (int i = 0; i < number; i++) {

                input[i] = Integer.parseInt(str[i]);


            }
            getArea(input, number);
        }

    }

    private static char[] getArea(int[] input, int number) {
        // TODO Auto-generated method stub

        Stack<Integer> s = new Stack<Integer>();

        int max = 0;
        int size = 0;
        int topStack;
        int area;

        int i = 0;
        while (i < number) {
            if (s.isEmpty() || input[s.peek()] <= input[i]) {
                s.push(i++);
            } else {
                topStack = s.pop();

                int nxt = (s.isEmpty()) ? i : i - s.peek() - 1;

                area = input[topStack] * nxt;

                if (max < area) {
                    max = area;
                    size = s.size();
                }
            }
        }

        while (!s.isEmpty()) {
            topStack = s.pop();

            int nxt = (s.isEmpty()) ? i : i - s.peek() - 1;

            area = input[topStack] * nxt;

            if (max < area) {
                max = area;
                size = s.size();
            }
        }

        System.out.println(max + " " + s.size());

        return null;
    }

}
