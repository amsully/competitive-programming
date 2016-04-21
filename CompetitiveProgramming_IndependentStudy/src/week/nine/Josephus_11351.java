package week.nine;

import java.util.*;
public class Josephus_11351 {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int t = Integer.parseInt(scan.nextLine());
		String output = "";
		for (int i = 1; i <= t; i++){
			String[] spl = scan.nextLine().split(" ");
			int n = Integer.parseInt(spl[0]);
			int k = Integer.parseInt(spl[1]);
			int person = joe(n,k);
			output += "Case " + i + ": " + (person+1) + "\n";
		}
		output = output.trim();
		System.out.println(output);
	}
	
	static int joe(int n, int k){
		if (n == 1) return 0;
		return (joe(n-1,k)+k) % n;
	}
}
