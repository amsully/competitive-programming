package week.five;

import java.util.*;

public class Bombs_10653 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (true) {
			String[] spl = scan.nextLine().split(" ");
			int r = Integer.parseInt(spl[0]);
			int c = Integer.parseInt(spl[1]);
			if (r == 0 && c == 0)
				break;

			int[][] board = new int[r][c];
			boolean[][] bombs = new boolean[r][c];
			boolean[][] been = new boolean[r][c];

			int brows = Integer.parseInt(scan.nextLine());
			for (int i = 0; i < brows; i++) {
				int br = scan.nextInt();
				int brs = scan.nextInt();
				for (int j = 0; j < brs; j++) {
					bombs[br][scan.nextInt()] = true;
				}
			}

			spl = scan.nextLine().split(" ");
			int fx = Integer.parseInt(spl[0]);
			int fy = Integer.parseInt(spl[1]);
			spl = scan.nextLine().split(" ");
			int tx = Integer.parseInt(spl[0]);
			int ty = Integer.parseInt(spl[1]);

			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if (i != fx && j != fy) {
						board[i][j] = 5000;
					}
				}
			}
			been[fx][fy] = true;

			LinkedList<Tuple> queue = new LinkedList<>();
			add(queue,been,bombs,fx-1,fy,r,c);
			add(queue,been,bombs,fx+1,fy,r,c);
			add(queue,been,bombs,fx,fy-1,r,c);
			add(queue,been,bombs,fx,fy+1,r,c);
			
			while (!queue.isEmpty()){
				
			}

		}
	}
	
	public static void add(LinkedList<Tuple> queue, boolean[][] been, boolean[][] bombs, int x, int y, int r, int c){
		if (x >= 0 && x < r && y >= 0 && y < c && !been[x][y] && !bombs[x][y]){
			queue.add(new Tuple(x,y));
		}
	}

}

class Tuple {
	public int x, y;

	public Tuple(int _x, int _y) {
		x = _x;
		y = _y;
	}
}
