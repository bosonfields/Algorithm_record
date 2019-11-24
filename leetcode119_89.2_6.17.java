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
        int rowIndex = 3;

        List<Integer> res = getRow(rowIndex);
        System.out.println(res.toString());
    }
    public static List<Integer> getRow(int rowIndex){
        List<Integer> res = new ArrayList<>();
        res.add(1);

        for(int i = 1; i<=rowIndex; i++){
            for(int j = i-1; j>=1; j--){
                res.set(j, (res.get(j-1)+ res.get(j)));
            }
            res.add(1);
        }
        return res;
    }
}
