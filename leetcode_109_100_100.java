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
        int[] nums = {-10, -3, 0, 5, 9};
        ListNode curr = new ListNode(0);
        ListNode root = curr;
        for(int i: nums){
            curr.next = new ListNode(i);
            curr = curr.next;
        }

        TreeNode res = SortedArrayToBST(root.next);
        List<String> tmp = PrinTree(res);
        System.out.println(tmp.toString());
    }

    public static TreeNode SortedArrayToBST(ListNode head){
        return helper(head, null);
    }
    public  static TreeNode helper(ListNode head, ListNode tail){

        if(head == tail) return null;

        ListNode mid = head;
        ListNode end = head;

        while(end!=tail && end.next!=tail){

            mid = mid.next;
            end = end.next.next;
        }
        TreeNode root = new TreeNode(mid.val);
        root.left = helper(head, mid);
        root.right = helper(mid.next, tail);
        return root;
    }
}
