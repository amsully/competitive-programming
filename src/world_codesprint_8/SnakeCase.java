package world_codesprint_8;

import java.util.Scanner;

/**
 * Created by ams on 12/17/16.
 */
public class SnakeCase {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();

        System.out.println(s.split("_").length);

    }
}