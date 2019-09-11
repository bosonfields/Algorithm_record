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

    public void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(30);

        root.left.left = new TreeNode(-2);
        root.left.right = new TreeNode(6);

        root.right.right = new TreeNode(-1);

        root.left.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(8);

        root.left.left.right.left = new TreeNode(40);

        recoverTree(root);

        List<String> tmp = new ArrayList<>();
        PrinTree(root, tmp);
        System.out.println(tmp.toString());
    }

    public void recoverTree(TreeNode root){
        if(root == null) return;
        TreeNode[] tArr = new TreeNode[4];
        tArr[0] = root;
        TreeNode pred = null;

        while(tArr[0]!=null){
            if(tArr[0].left!=null){
                pred = tArr[0].left;
                while(pred.right!=null && pred.right!=tArr[0]) pred = pred.right;
                if(pred.right==null){
                    pred.right = tArr[0];
                    tArr[0] = tArr[0].left;
                }else{
                    visit(tArr);
                    pred.right = null;
                    tArr[0] = tArr[0].right;
                }
            }else{
                visit(tArr);
                tArr[0] = tArr[0].right;
            }
        }
        swap(tArr);

    }
    private void visit(TreeNode[] tArr){
        if(tArr[1]!= null && tArr[0].val<tArr[1].val){
            tArr[2] = tArr[2]==null? tArr[1]: tArr[2];
            tArr[3] = tArr[0];
        }
        tArr[1] = tArr[0];
    }
    private void swap(TreeNode[] tArr){
        if(tArr[2]==null | tArr[3] == null) return;

        int tmp = tArr[2].val;
        tArr[2].val = tArr[3].val;
        tArr[3].val = tmp;
    }
}
