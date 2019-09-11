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
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);


        List<List<Integer>> ans = zigzagLevelOrder(root);

        for(List<Integer> ls: ans){
            System.out.println(ls.toString());
        }
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root){
        List<List<Integer>> ans = new ArrayList<>();
        Bfs(ans, root, 0);
        return ans;
    }
    static void Bfs(List<List<Integer>> ans, TreeNode root, int height){
        if(root == null) return;

        if(ans.size()==height){
            ans.add(new ArrayList<>());
        }

        List<Integer> tmp = ans.get(height);

        if(height%2==1){
            tmp.add(0, root.val);
        }else{
            tmp.add(root.val);
        }

        Bfs(ans, root.left, height+1);
        Bfs(ans, root.right, height+1);
    }
}
