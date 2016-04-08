package week.two;

import java.util.*;

public class Brain_10507 {

	private class Node {

		public int key;
		public HashSet<Integer> adj;

		public Node(int k) {
			key = k;
			adj = new HashSet<Integer>();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

		String line;
		while ((line = scan.nextLine()) != null) {
			ArrayList<Node> g = new ArrayList<>();
			HashSet<Integer> onSet = new HashSet<>();
			int n = Integer.parseInt(line);
			for (int i = 0; i < 26; i++) {
				g.add(new Brain_10507().new Node(i));
			}
			int m = Integer.parseInt(scan.nextLine());

			line = scan.nextLine();
			onSet.add(cc(line.charAt(0)));
			onSet.add(cc(line.charAt(1)));
			onSet.add(cc(line.charAt(2)));

			for (int i = 0; i < m; i++) {
				line = scan.nextLine();
				g.get(cc(line.charAt(0))).adj.add(cc(line.charAt(1)));
				g.get(cc(line.charAt(0))).adj.add(cc(line.charAt(0)));
			}
			runOnGraph(g, onSet, n);

		}
		scan.close();
	}

	private static void runOnGraph(ArrayList<Node> g, HashSet<Integer> onSet,
			int n) {
		int count = 0;
		while (onSet.size() != n && count < n) {
			HashSet<Integer> temp = new HashSet<>();
			temp.addAll(onSet);
			System.out.println("onSet: " + onSet.toString());
			for (int i = 0; i < g.size(); i++) {
				//System.out.println(" g[" + i + "]: " + g.get(i).adj.toString());
				if (possible(g.get(i).adj, temp)) {
					onSet.add(i);
				}
			}
			onSet.addAll(temp);
			count++;
		}
		if (count < n) {
			System.out.println("WAKE UP IN, " + count + ", YEARS");
		} else {
			System.out.println("THIS BRAIN NEVER WAKES UP");
		}

	}
	
	private static boolean possible(HashSet<Integer> adj, HashSet<Integer> onSet){
		if (adj.size() < 3) return false;
		
		int count = 0;
		for (Integer i : adj){
			if (onSet.contains(i)){
				count++;
			}
		}
		
		return count >= 3;
	}

	private static int cc(char c) {
		return c - 65;
	}

}
