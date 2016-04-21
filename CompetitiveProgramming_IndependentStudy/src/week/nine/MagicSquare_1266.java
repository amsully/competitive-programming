package week.nine;

import java.util.*;

public class MagicSquare_1266 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String line;

		while (true) {
			int sum;
			line = scan.nextLine();
			if (line == null) {
				break;
			}
			int n = Integer.parseInt(line);
			int[][] magic = new int[n][n];
			if (n == 1) {
				magic[0][0] = 1;
				sum = 1;
			} else {
				int row = n - 1;
				int col = n / 2;
				magic[row][col] = 1;

				for (int i = 2; i <= n * n; i++) {
					if (magic[(row + 1) % n][(col + 1) % n] == 0) {
						row = (row + 1) % n;
						col = (col + 1) % n;
					} else
						row = (row - 1 + n) % n;
					magic[row][col] = i;
				}
				sum = 0;
				for (int i = 0; i < n; i++) {
					sum += magic[i][0];
				}
			}
			System.out.println("n=" + n + ", sum=" + sum);
			String output = "";
			for (int i = 0; i < magic.length; i++) {
				String temp = "";
				for (int j = 0; j < n; j++) {
					temp += magic[j][i] + " ";
				}
				output += " " + temp.trim() + "\n";
			}
			System.out.println(output);
		}
		scan.close();
	}
}
