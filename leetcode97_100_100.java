package leet_test;

        import apple.laf.JRSUIUtils;
        import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
        import org.omg.PortableServer.LIFESPAN_POLICY_ID;
        import org.w3c.dom.ls.LSException;

        import java.text.DateFormatSymbols;
        import java.util.*;

public class Main {

    public static void main(String[] args) {
        String s1 = "";
        String s2 = "dbbca";
        String s3 = "dbbca";
        boolean ans = isInterleave(s1, s2, s3);
        System.out.println(ans);
    }

    public static boolean isInterleave(String s1, String s2, String s3){
        if(s1.length()+s2.length() != s3.length()) return false;

        char[] s1arr = s1.toCharArray();
        char[] s2arr = s2.toCharArray();
        char[] s3arr = s3.toCharArray();

        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];

        boolean ans = Dfs(s1arr, s2arr, s3arr, 0, 0, 0, dp);
        return ans ;
    }
    public static boolean Dfs(char[] arr1, char[] arr2, char[] arr3, int i, int j, int k, boolean[][] dp){

        if(dp[i][j]) return false;
        if(k==arr3.length) return true;

        dp[i][j] = !((i<arr1.length && arr1[i] == arr3[k] && Dfs(arr1, arr2, arr3, i+1, j, k+1, dp)) ||
                (j<arr2.length && arr2[j] == arr3[k] && Dfs(arr1, arr2, arr3, i, j+1, k+1, dp)));

        return !dp[i][j];
    }

}
