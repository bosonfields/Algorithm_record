package leet_test;

        import java.util.*;

public class Main {

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) {val=x;}
    }

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public static class Node{
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node(){}

        public Node(int _val, Node _left, Node _right, Node _next){
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }


//    public static List<String> PrinTree(TreeNode root){
//        List<String> tmp = new ArrayList<>();
//        if(root == null){
//            tmp.add("null");
//            return tmp;
//        }
//        LinkedList<TreeNode> ls = new LinkedList<>();
//
//        tmp.add(String.valueOf(root.val));
//
//        TreeNode nxt;
//        ls.add(root);
//
//        while(!ls.isEmpty()){
//            nxt = ls.pollFirst();
//
//            if(nxt.right==null && nxt.left==null) continue;
//
//            if(nxt.left == null) tmp.add("null");
//
//            else{
//                tmp.add(String.valueOf(nxt.left.val));
//                ls.add(nxt.left);
//            }
//            if(nxt.right == null) tmp.add("null");
//            else{
//                tmp.add(String.valueOf(nxt.right.val));
//                ls.add(nxt.right);
//            }
//        }
//        return tmp;
//    }

    public static class Point{
        int x, y;
        Point(){this.x = 0; this.y = 0;}
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static class UndirectedGraphNode{
        int label;
        ArrayList<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) {
            label = x; neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }

    public static class DirectedGraphNode {
      int label;
      ArrayList<DirectedGraphNode> neighbors;
      DirectedGraphNode(int x) {
          label = x; neighbors = new ArrayList<DirectedGraphNode>();
      }
    }

    public static void main(String[] args) {
        int a = 11, b = 123898, n = 12345;
        int res = fastPower(a, b, n);
        System.out.println(res);
    }

    public static int fastPower(int a, int b, int n) {
        if (n == 0) return 1 % b;
        if (n == 1) return a % b;

        long half = fastPower(a, b, n / 2);
        half = (half * half) % b;
        if (n % 2 == 1) {
            half = (half * a) % b;
        }
        return (int) half;
    }
}
