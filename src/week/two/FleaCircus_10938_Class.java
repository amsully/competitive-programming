package week.two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * rules: • There is exactly one way for the fleas to go from one leaf or fork
 * in the tree to another leaf or fork without ever turning back. Each of the
 * fleas starts jumping along such a route to the current location of the other
 * flea. • The fleas can only jump from one fork or leaf of the tree to another
 * fork or leaf if they are connected by a branch. • If the two fleas land at
 * the same time in the same place then they decide to sit and chat for quite a
 * while. • If the two fleas land at the same time in two neighboring places on
 * the tree (forks or leaves) then they keep jumping forever. Input The input
 * file contains multiple test cases. Each test case starts with an integer n,
 * the number of leaves and forks in the tree, 1 ≤ n ≤ 5000. We assume that
 * leaves and forks are numbered from 1 to n. Each of the following n − 1 lines
 * describe tree branches; each branch is described by two integers a and b,
 * meaning that the branch connects the fork or leaf labeled a and the fork or
 * leaf labeled b. In the (n + 1)-st line there is one integer l, 1 ≤ l ≤ 500,
 * saying how many starting positions of the fleas you are to consider for the
 * tree. Each of the following l lines contains two positive integers (not
 * greater than n). These numbers define the tree places in which the fleas
 * start their jumping. Input is terminated by the case with n equal to 0.
 * Output Your program should output l lines for each test case. The i-th line
 * for a case should look like The fleas meet at p. where p identifies the place
 * where the fleas meet, or The fleas jump forever between p and r. where p and
 * r are two neighboring places on the tree with p ≤ r. Sample Input 8 1 2 1 3 2
 * 4 2 5 3 6 3 7 5 8 5 5 1 7 4 1 8 4 7 7 8 0 Sample Output The fleas meet at 2.
 * The fleas meet at 1. The fleas jump forever between 2 and 5. The fleas meet
 * at 1. The fleas jump forever between 1 and 2.
 */
public class FleaCircus_10938_Class {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<Integer, LinkedList<Integer>> map = new HashMap<Integer, LinkedList<Integer>>();

        int branch = Integer.valueOf(br.readLine());

        for (int i = 0; i < branch - 1; i++) {

            String[] tmp = br.readLine().split(" ");
            int val1 = Integer.parseInt(tmp[0]);
            int val2 = Integer.parseInt(tmp[1]);

            if (!map.containsKey(val1)) {

                map.put(val1, new LinkedList<Integer>());

            }
            map.get(val1).add(val2);
            if (!map.containsKey(val2)) {
                map.put(val2, new LinkedList<Integer>());
            }
            map.get(val2).add(val1);


        }

        int fleaTrials = Integer.parseInt(br.readLine());

        for (int i = 0; i < fleaTrials; i++) {
            String[] tmp = br.readLine().split(" ");
            int flea1 = Integer.parseInt(tmp[0]);
            int flea2 = Integer.parseInt(tmp[1]);

            LinkedList<Integer> path = bfs(flea1, flea2, map);
        }

    }

    private static LinkedList<Integer> bfs(int flea1, int flea2, HashMap<Integer, LinkedList<Integer>> map) {
        // TODO Auto-generated method stub

        Queue<Integer> q = new LinkedList<Integer>();
        LinkedList<Integer> p = new LinkedList<Integer>();
        q.addAll(map.get(flea1));

        p.add(flea1);

        while (!q.isEmpty()) {

            Integer val = q.poll();

            q.addAll(map.get(val));
            p.add(val);

            if (val == flea2) {
                break;
            }

        }

        return p;
    }
}
