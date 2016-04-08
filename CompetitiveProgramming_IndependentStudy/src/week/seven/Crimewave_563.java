package week.seven;

import java.util.*;

public class Crimewave_563 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int p = Integer.parseInt(scan.nextLine());
		for (int _ = 0; _ < p; _++){
			String[] line1 = scan.nextLine().split(" ");
			int s = Integer.parseInt(line1[0]);
			int a = Integer.parseInt(line1[1]);
			int b = Integer.parseInt(line1[2]);
			
			boolean[][] taken = new boolean[s][a];
			int[] xs = new int[s];
			int[] ys = new int[a];
			for (int x = 0; x < b; x++){
				String[] bline = scan.nextLine().split(" ");
				xs[x] = Integer.parseInt(bline[0]);
				ys[x] = Integer.parseInt(bline[1]);
			}
		}
	}

}
