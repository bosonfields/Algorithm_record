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
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};

        TreeNode ans = buildTree(preorder, inorder);

        List<String> tmp = new ArrayList<>();
        PrinTree(ans, tmp);

        System.out.println(tmp.toString());
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder){
        return helper(preorder, inorder, new int[2], null);
    }
    public static TreeNode helper(int[] preorder, int[] inorder, int[] idx, TreeNode check){
        if(idx[0]>=preorder.length || (check!=null && inorder[idx[1]] == check.val)) return null;

        TreeNode root = new TreeNode(preorder[idx[0]]);
        idx[0]+=1;
        root.left = helper(preorder, inorder, idx, root);

        idx[1]+=1;
        root.right = helper(preorder, inorder, idx, check);
        return root;
    }
}
