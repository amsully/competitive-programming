package week.two;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class FleaCircus_10938_NullPtr {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        HashMap<Integer, Node> map = new HashMap<Integer, Node>();

        int n;
        while ((n = scan.nextInt()) != 0) {
            for (int i = 0; i < n - 1; i++) {

                int val1 = scan.nextInt();
                int val2 = scan.nextInt();

                createTree(val1, val2, map);

            }

            int trials = scan.nextInt();
            for (int i = 0; i < trials; i++) {
                int flea1 = scan.nextInt();
                int flea2 = scan.nextInt();

                findMeetingPoint(flea1, flea2, map);
            }

            map.clear();
        }

        scan.close();
        System.exit(0);
    }

    private static void findMeetingPoint(int flea1, int flea2, HashMap<Integer, Node> map) {
        // TODO Auto-generated method stub
        Node parent = new Node(0);
        Node root = map.get(1);

        LinkedList<Integer> path1 = new LinkedList<Integer>();
        LinkedList<Integer> path2 = new LinkedList<Integer>();


        findPath(root, parent, flea1, path1);
        findPath(root, parent, flea2, path2);

        int tempKey = -1;

        while (!path1.isEmpty() && !path2.isEmpty() && path1.get(0) == path2.get(0)) {

            tempKey = path1.getFirst();
            path1.removeFirst();
            path2.removeFirst();

        }
        if (tempKey != -1) {
            path1.addFirst(tempKey);
            path2.addFirst(tempKey);
        }

        if ((path1.size() + path2.size()) % 2 == 0) {

            printMeetingPoint(path1, path2);
        } else {
            printForeverPoints(path1, path2);
        }

    }

    private static void printForeverPoints(LinkedList<Integer> path1, LinkedList<Integer> path2) {

        path1.removeFirst();
        for (Integer v : path1) {
            path2.addFirst(v);
        }
        while (path2.size() != 2) {

            path2.removeLast();
            path2.removeFirst();
        }
        Collections.sort(path2);
        System.out.println("The fleas jump forever between " + path2.get(0) + " and " + path2.get(1) + ".");
    }

    private static void printMeetingPoint(LinkedList<Integer> path1, LinkedList<Integer> path2) {
        // TODO Auto-generated method stub

        path1.removeFirst();
        for (Integer v : path1) {
            path2.addFirst(v);
        }
        while (path2.size() != 1) {

            path2.removeLast();
            path2.removeFirst();
        }

        System.out.println("The fleas meet at " + path2.get(0) + ".");

    }

    private static boolean findPath(Node root, Node parent, int flea2, LinkedList<Integer> path) {
        // TODO Auto-generated method stub
//                System.out.println(path.toString());
        if (root == null) return false;

        path.add(root.key);

        if (root.key == flea2) {
            return true;
        }

        if (root.children.isEmpty()) {
            path.removeLast();
            return false;
        }

        for (Node child : root.children) {
            if (!child.equals(parent) && findPath(child, root, flea2, path)) {
                return true;
            }
        }

        path.removeLast();
        return false;

    }

    private static void createTree(int val1, int val2, HashMap<Integer, Node> map) {
        // TODO Auto-generated method stub
        Node tmp;
        if (!map.containsKey(val1)) {
            tmp = new Node(val1);
            map.put(val1, tmp);

        } else {
            tmp = map.get(val1);
        }

        Node pathNode;
        if (!map.containsKey(val2)) {
            pathNode = new Node(val2);

            map.put(val2, pathNode);

        } else {
            pathNode = map.get(val2);
        }
        tmp.add(pathNode);
        pathNode.add(tmp);

    }

}

class Node {

    int key = -1;
    LinkedList<Node> children;

    public Node(int val) {

        key = val;
        children = new LinkedList<Node>();
    }

    public boolean hasKey() {
        // TODO Auto-generated method stub
        return key > 0;
    }

    public void add(Node l) {
        children.add(l);
    }

}