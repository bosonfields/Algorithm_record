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


    public static List<String> PrinTree(TreeNode root){
        List<String> tmp = new ArrayList<>();
        if(root == null){
            tmp.add("null");
            return tmp;
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
        return tmp;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.right.right = new TreeNode(3);
        root.right.left = new TreeNode(4);

        flatten(root);

        List<String> tmp = PrinTree(root);

        System.out.println(tmp.toString());

    }
    public static void flatten(TreeNode root){
        if(root == null) return;

        TreeNode curr = root;

        while(curr!=null){
            if(curr.left!=null){
                TreeNode tmp = curr.left;
                while(tmp.right!=null) tmp = tmp.right;
                tmp.right = curr.right;
                curr.right = curr.left;
                curr.left=null;
            }
            curr = curr.right;
        }
    }
}
