package week.eight;

import java.util.*;

public class DNA_760 {
	
	static int[][] lcs;
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		String a = scan.nextLine();
		String b = scan.nextLine();
		scan.close();
		lcs = new int[a.length()+1][b.length()+1];
		lcs(a.toCharArray(),b.toCharArray());
		Set<String> res = lcs(a,b,a.length(),b.length());
		for (String s : res){
			System.out.println(s);
		}
	}
	
	static void lcs(char[] a, char[] b) {
		int al = a.length;
		int bl = b.length;
		
		if (a[0] == b[0]){
			lcs[0][0] = 1;
		}
		
		for (int i = 1; i < al; i++){
			lcs[i][0] = Math.max(lcs[i-1][0], (a[i]==b[0] ? 1 : 0));
		}
		for (int j = 1; j < bl; j++){
			lcs[0][j] = Math.max(lcs[0][j-1], (a[0]==b[j] ? 1 : 0));
		}
		
		for (int i = 1; i < al; i++){
			for (int j = 1; j < bl; j++){
				if (a[i] == b[j]){
					lcs[i][j] = lcs[i-1][j-1]+1;
				} else {
					lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
				}
			}
		}
	}

	static Set<String> lcs(String s1, String s2, int len1, int len2) {
	    if (len1 == 0 || len2 == 0) {
	        Set<String> set = new HashSet<String>();
	        set.add("");
	        return set;
	    }
	    if (s1.charAt(len1 - 1) == s2.charAt(len2 - 1)) {
	        Set<String> set = lcs(s1, s2, len1 - 1, len2 - 1);
	        Set<String> set1 = new HashSet<>();
	        for (String temp : set) {
	            temp = temp + s1.charAt(len1 - 1);
	            set1.add(temp);
	        }
	        return set1;
	    } else {
	        Set<String> set = new HashSet<>();
	        Set<String> set1 = new HashSet<>();
	        if (lcs[len1 - 1][len2] >= lcs[len1][len2 - 1]) {
	            set = lcs(s1, s2, len1 - 1, len2);
	        }
	        if (lcs[len1][len2 - 1] >= lcs[len1 - 1][len2]) {
	            set1 = lcs(s1, s2, len1, len2 - 1);
	        }
	        for (String temp : set) {
	            set1.add(temp);
	        }
	        //System.out.println("In lcs" + set1);
	        return set1;

	    }
	}
}
