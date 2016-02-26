package week.three;

import java.util.*;

public class Elephants_10131 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<Elephant> orig = new ArrayList<>();
		ArrayList<Elephant> wes = new ArrayList<>();
		ArrayList<Elephant> iqs = new ArrayList<>();

		int index = 1;
		while (scan.hasNextLine()) {
			String line = scan.nextLine();
			if (line.equals("")) {
				break;
			}
			String[] l = line.split(" ");

			int w = Integer.parseInt(l[0]);
			int iq = Integer.parseInt(l[1]);
			orig.add(new Elephant(w, iq, index));
			wes.add(new Elephant(w, iq, index));
			iqs.add(new Elephant(w, iq, index));
			index++;
		}

		Comparator<Elephant> iq_comp = new Comparator<Elephant>() {
			public int compare(Elephant a, Elephant b) {
				return a.iq - b.iq;
			}
		};

		Comparator<Elephant> we_comp = new Comparator<Elephant>() {
			public int compare(Elephant a, Elephant b) {
				return a.w - b.w;
			}
		};

		Collections.sort(wes, we_comp);
		Collections.sort(iqs, iq_comp);
		
		System.out.println("  wes:");
		for (Elephant e : wes){
			System.out.println(e.toString());
		}
		
		System.out.println("\n  iqs:");
		for (Elephant e : iqs){
			System.out.println(e.toString());
		}

		ArrayList<Elephant> we_l = getLongest(orig, wes, iq_comp);
		ArrayList<Elephant> iq_l = getLongest(orig, iqs, we_comp);
		System.out.println("\n  wes_lcs:");
		for (int i = 0; i < we_l.size(); i++) {
			System.out.println(we_l.get(i).toString());
		}
		System.out.println("\n  iqs_lcs:");
		for (int i = 0; i < iq_l.size(); i++) {
			System.out.println(iq_l.get(i).toString());
		}

	}

	private static ArrayList<Elephant> getLongest(ArrayList<Elephant> orig,
			ArrayList<Elephant> other, Comparator<Elephant> comp) {

		int[][] board = new int[orig.size()][other.size()];
		board[0][0] = (comp.compare(orig.get(0), other.get(0)) == 0) ? 1 : 0;
		for (int i = 1; i < orig.size(); i++) {
			board[i][0] = Math.max(board[i - 1][0],
					comp.compare(orig.get(i), other.get(0)) == 0 ? 1 : 0);
			board[0][i] = Math.max(board[0][i - 1],
					comp.compare(orig.get(0), other.get(i)) == 0 ? 1 : 0);

		}

		for (int i = 1; i < orig.size(); i++) {
			for (int j = 1; j < other.size(); j++) {
				Elephant e1 = orig.get(i);
				Elephant e2 = other.get(j);
				if (comp.compare(e2, e1) == 0) {
					board[i][j] = board[i - 1][j - 1] + 1;
				} else {
					board[i][j] = Math.max(board[i - 1][j], board[i][j - 1]);
				}
			}
		}
		
		System.out.println("\n max: " + board[orig.size()-1][orig.size()-1]);

		ArrayList<Integer> back = new ArrayList<Integer>();

		int i = orig.size() - 1;
		int j = orig.size() - 1;

		while (i >= 0 && j >= 0) {
			if (i == 0 || j == 0) {
				if (comp.compare(orig.get(i), other.get(j)) == 0) {
					back.add(orig.get(i).index);
				}
				i--;
				j--;
			} else if (board[i][j] - 1 == board[i - 1][j - 1]) {
				System.out.println("i: " + i + " j:" + j);
				back.add(orig.get(i).index);
				i--;
				j--;
			} else {
				i--;
			}
		}

		ArrayList<Elephant> els = new ArrayList<Elephant>();
		for (Integer num : back) {
			System.out.println(num-1);
			els.add(orig.get(num-1));
		}
		System.out.println();
		return els;
	}
}

class Elephant {
	public int iq;
	public int w;
	public int index;

	public Elephant(int we, int i, int index) {
		this.index = index;
		iq = i;
		w = we;
	}

	public int compareTo(Elephant e) {
		return e.iq - this.iq;
	}

	public String toString() {
		return "w: " + w + ", iq: " + iq;
	}
}
