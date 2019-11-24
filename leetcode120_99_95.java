package leet_test;

        import apple.laf.JRSUIUtils;
        import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
        import org.omg.PortableServer.LIFESPAN_POLICY_ID;
        import org.w3c.dom.ls.LSException;

        import java.text.DateFormatSymbols;
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
            val=x;
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

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();

        List<Integer> tmp1 = new ArrayList<>();

        tmp1.add(1);

        List<Integer> tmp2 = new ArrayList<>();
        tmp2.add(2); tmp2.add(3);

        List<Integer> tmp3 = new ArrayList<>();
        tmp3.add(4); tmp3.add(5); tmp3.add(6);

        triangle.add(tmp1);
        triangle.add(tmp2);
        triangle.add(tmp3);

        int res = getRow(triangle);
        System.out.println(res);

    }
    public static int getRow(List<List<Integer>> triangle){
        if(triangle==null) return 0;

        Integer[][] dp = new Integer[triangle.size()][triangle.size()];
        return Bfs(triangle, 0, 0, dp);
    }
    public static int Bfs(List<List<Integer>> triangle, int level, int idx, Integer[][] dp){
        if(level == dp.length){
            return 0;
        }

        if(dp[level][idx]!=null) return dp[level][idx];

        int left = Bfs(triangle, level+1, idx, dp);
        int right = Bfs(triangle, level+1, idx+1, dp);

        dp[level][idx] = triangle.get(level).get(idx) + Math.min(left, right);

        return dp[level][idx];
    }
}
