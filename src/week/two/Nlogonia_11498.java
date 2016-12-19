package week.two;

import java.util.Scanner;

/**
 * Accepted
 *
 * @author bob
 */

public class Nlogonia_11498 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int k = Integer.parseInt(scan.nextLine());

        while (k != 0) {
            int dx = scan.nextInt();
            int dy = scan.nextInt();

            for (int i = 0; i < k; i++) {
                int tx = scan.nextInt();
                int ty = scan.nextInt();

                if (tx == dx || ty == dy) {
                    System.out.println("divisa");
                } else if (dx < tx && dy < ty) {
                    System.out.println("NE");
                } else if (dx < tx && dy > ty) {
                    System.out.println("SE");
                } else if (dx > tx && dy > ty) {
                    System.out.println("SO");
                } else {
                    System.out.println("NO");
                }
            }
            k = scan.nextInt();
        }
        scan.close();

    }

}
