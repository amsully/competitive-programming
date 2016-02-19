package week.two;

import java.util.*;

public class PingPong_1428 {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		String[] line;
		
		int t = Integer.parseInt(scan.nextLine());
		for (int _i = 0; _i < t; _i++){
			line = scan.nextLine().split(" ");
			int n = Integer.parseInt(line[0]);
			int[] game = new int[n];
			for (int i = 0; i < n; i++){
				game[i] = Integer.parseInt(line[i+1]);
			}
			
			runNaive(game);
		}
	}
	
	private static void runNaive(int[] game){
		int count = 0;
		for (int i = 0; i < game.length; i++){
			for (int j = 0; j < i-1; j++){
				int high = Math.max(game[i], game[j]);
				int low = Math.min(game[i], game[j]);
				int curr = j+1;
				while (curr < i){
					if (game[curr] < high && game[curr] > low){
						count++;
					}
					curr++;
				}
			}
		}
		System.out.println(count);
	}
}
