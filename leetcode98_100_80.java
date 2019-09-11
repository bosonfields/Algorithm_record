package leet_test;

        import apple.laf.JRSUIUtils;
        import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
        import org.omg.PortableServer.LIFESPAN_POLICY_ID;
        import org.w3c.dom.ls.LSException;

        import java.text.DateFormatSymbols;
        import java.util.*;

public class Main {

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val=x;
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(Integer.MIN_VALUE);
        root.left = new TreeNode(2);
//        root.right = new TreeNode(Integer.MAX_VALUE);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(Integer.MIN_VALUE);

        boolean res = isValidBST(root);
        System.out.println(res);
    }

    public static boolean isValidBST(TreeNode root){
        if(root==null) return true;

        return helper(root, null, null);

    }

    public  static boolean helper(TreeNode root, TreeNode min, TreeNode max){
        if(root == null) return true;

        if(min!=null && root.val<= min.val) return false;

        if(max!=null && root.val>=max.val) return false;

        return (helper(root.left, min, root) && helper(root.right, root, max));
    }
}
