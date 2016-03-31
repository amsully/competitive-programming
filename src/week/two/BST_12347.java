package week.two;

import java.util.*;

/**
 * unsolved
 * @author bob
 *
 */

public class BST_12347 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<Integer> t = new ArrayList<>();
		String line;

		while ((line = scan.nextLine()) != null && line != "") {
			t.add(Integer.parseInt(line));
		}

		Stack<Integer> stack = new Stack<>();
		stack.push(t.get(0));
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < t.size(); i++) {
			if (t.get(i) < stack.peek()) {
				stack.push(t.get(i));
			} else {
				while (t.get(i) > stack.peek()) {
					sb.append(stack.pop() + " ");
				}
				stack.push(t.get(i));
			}
		}
		
		while (!stack.isEmpty()){
			sb.append(stack.pop() + " ");
		}
		
		System.out.println(sb.toString().trim());

	}
}
