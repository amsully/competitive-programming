package week.six;

import java.util.*;
import java.util.Map.Entry;

public class Prof_10171 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = Integer.parseInt(scan.nextLine().trim());
		while (N != 0){
			int MAX = 1000000;
			HashSet<String> keys = new HashSet<>();
			HashMap<String, HashMap<String,Integer>> young = new HashMap<>();
			HashMap<String, HashMap<String,Integer>> old = new HashMap<>();
			for (int _ = 0; _ < N; _++){
				String[] espl = scan.nextLine().trim().split(" ");
				keys.add(espl[2]);
				keys.add(espl[3]);
				if (espl[0].equals("Y")){
					if (espl[1].equals("B")){
						if (!young.containsKey(espl[3])){
							young.put(espl[3], new HashMap<String, Integer>());
						}
						young.get(espl[3]).put(espl[2],Integer.parseInt(espl[4]));
					}
					if (!young.containsKey(espl[2])){
						young.put(espl[2], new HashMap<String, Integer>());
					}
					young.get(espl[2]).put(espl[3],Integer.parseInt(espl[4]));
				} else {
					if (espl[1].equals("B")){
						if (!old.containsKey(espl[3])){
							old.put(espl[3], new HashMap<String, Integer>());
						}
						old.get(espl[3]).put(espl[2],Integer.parseInt(espl[4]));
					}
					if (!old.containsKey(espl[2])){
						old.put(espl[2], new HashMap<String, Integer>());
					}
					old.get(espl[2]).put(espl[3],Integer.parseInt(espl[4]));
				}
			}
			
			String[] strtspl = scan.nextLine().trim().split(" ");
			
			String[] ks = keys.toArray(new String[keys.size()]);
			
			HashMap<String, Integer> inds = new HashMap<>();
			for (int i = 0; i < ks.length; i++){
				inds.put(ks[i], i);
			}
			
			int ystart = inds.get(strtspl[0]);
			int ostart = inds.get(strtspl[1]);
			
			int ns = ks.length;
			
			int[][] ydist = new int[ns][ns];
			int[][] odist = new int[ns][ns];
			
			for (int i = 0; i < ns; i++){
				for (int j = 0; j < ns; j++){
					ydist[i][j] = MAX;
					odist[i][j] = MAX;
				}
			}
			
			for(String key : young.keySet()){
				for (Entry<String, Integer> e : young.get(key).entrySet()){
					ydist[inds.get(key)][inds.get(e.getKey())] = e.getValue();
				}
			}
			for (String key : old.keySet()){
				for (Entry<String, Integer> e: old.get(key).entrySet()){
					odist[inds.get(key)][inds.get(e.getKey())] = e.getValue();
				}
			}
			
			for (int k = 0; k < ns; k++){
				for (int i = 0; i < ns; i++){
					for (int j = 0; j < ns; j++){
						if (odist[i][j] > odist[i][k] + odist[k][j]){
							odist[i][j] = odist[i][k] + odist[k][j];
						}
						if (ydist[i][j] > ydist[i][k] + ydist[k][j]){
							ydist[i][j] = ydist[i][k] + ydist[k][j];
						}
					}
				}
			}
			
			int ans = -1;
			int min = 0;
			for (int i = 0; i < ns; i++){
				if (ydist[ystart][i] != MAX && odist[ostart][i] != MAX){
					int tot = ydist[ystart][i] + odist[ostart][i];
					if (min == 0 || tot < min){
						min = tot;
						ans = i;
					}
				}
			}
			
			if (min == 0){
				System.out.println("You will never meet.");
			} else {
				System.out.println(min + " " + ks[ans]);
			}
			
			
			N = Integer.parseInt(scan.nextLine().trim());
		}
		scan.close();
		
	}

}
