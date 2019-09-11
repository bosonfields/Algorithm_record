package leet_test;

        import apple.laf.JRSUIUtils;
        import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
        import org.omg.PortableServer.LIFESPAN_POLICY_ID;
        import org.w3c.dom.ls.LSException;
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

    public static void main(String[] args) {
        int n = 1;
        List<TreeNode> res = generateTrees(n);

        for(TreeNode ts: res){
            List<String> tmp = new ArrayList<>();
            PrinTree(ts, tmp);
            System.out.println(tmp.toString());
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

    public static List<TreeNode> generateTrees(int n){
        if(n==0) return new ArrayList<>();

        List<TreeNode>[][] dp = new List[n+1][n+1];

        dp[0][0] = new ArrayList<>();
        dp[0][0].add(null);

        for(int i = 1; i<n+1; i++){
            dp[i][i] = new ArrayList<>();
            dp[i][i].add(new TreeNode(i));
        }

        List<TreeNode> res =  divCouq(dp, 1, n);

        return res;
    }

    public static List<TreeNode> divCouq(List<TreeNode>[][] dp, int lo, int hi){
        if(lo>hi) return dp[0][0];

        if(dp[lo][hi]!=null) return dp[lo][hi];

        List<TreeNode> res = new ArrayList<>();

        for(int k = lo; k<hi+1; k++){

            List<TreeNode> left = divCouq(dp, lo, k-1);
            List<TreeNode> right = divCouq(dp, k+1, hi);

            for(TreeNode lt: left){
                for(TreeNode rt: right){

                    TreeNode root = new TreeNode(k);
                    root.left = lt;
                    root.right = rt;
                    res.add(root);
                }
            }
        }


        dp[lo][hi] = res;
        return res;
    }

}
