package week.eight;

import java.util.*;

public class Palindrom_11475 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String line;
		while ((line = scan.nextLine()) != null){
			if (isPalindrome(line)){
				System.out.println(line);
			} else {
				String left = palinAddToLeft(line);
				String right = palinAddToRight(line);
				System.out.println(left.length() < right.length() ? left : right);
			}
		}
	}
	
	static String palinAddToLeft(String line){
		for (int i = line.length(); i >= 0; i--){
			String check = line.substring(0, i);
			if (isPalindrome(check)){
				StringBuilder sb = new StringBuilder(line.substring(i,line.length()));
				sb = sb.reverse();
				return sb.toString() + line;
			}
		}
		
		return line;
	}
	
	static String palinAddToRight(String line){
		for (int i = 0; i <= line.length(); i++){
			String check = line.substring(i,line.length());
			if (isPalindrome(check)){
				StringBuilder sb = new StringBuilder(line.substring(0,i));
				sb = sb.reverse();
				return line + sb.toString();
			}
		}
		
		return line;
	}
	
	static boolean isPalindrome(String line){
		char[] str = line.toCharArray();
		int l = str.length-1;
		for (int i = 0; i < ((str.length/2) + 1); i++){
			if (str[i] != str[l-i]){
				return false;
			}
		}
		return true;
	}

}
