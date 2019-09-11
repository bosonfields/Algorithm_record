package leet_test;

        import apple.laf.JRSUIUtils;
        import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
        import org.omg.PortableServer.LIFESPAN_POLICY_ID;
        import org.w3c.dom.ls.LSException;

        import java.text.DateFormatSymbols;
        import java.util.*;

public class Main {

//    public static class ListNode{
//        int val;
//        ListNode next;
//        ListNode(int x) {val=x;}
//    }

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val=x;
        }
    }


    public static void PrinTree(TreeNode root, List<String> tmp){
        if(root == null){
            tmp.add("null");
            return;
        }
        LinkedList<TreeNode> ls = new LinkedList<>();

        tmp.add(String.valueOf(root.val));

        TreeNode nxt;
        ls.add(root);

        while(!ls.isEmpty()){
            nxt = ls.pollFirst();
            if(nxt.right==null && nxt.left==null) continue;
            if(nxt.left == null) tmp.add("null");
            else{
                tmp.add(String.valueOf(nxt.left.val));
                ls.add(nxt.left);
            }
            if(nxt.right == null) tmp.add("null");
            else{
                tmp.add(String.valueOf(nxt.right.val));
                ls.add(nxt.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.right.right = new TreeNode(3);


        boolean ans = isSymmetric(root);
        System.out.println(ans);
    }

    public static boolean isSymmetric(TreeNode root){
        if(root ==null) return true;
        return check(root.left, root.right);

    }
    public static boolean check(TreeNode q, TreeNode p){
        if(q==null && p== null) return true;
        if(q==null || p==null) return false;
        if(q.val == p.val) return check(q.left, p.right) && check(q.right, p.left);
        else return false;
    }
}
