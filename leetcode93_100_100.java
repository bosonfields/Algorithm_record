package leet_test;

        import org.w3c.dom.ls.LSException;

        import java.util.*;

public class Main {

//    public static class ListNode{
//        int val;
//        ListNode next;
//        ListNode(int x) {val=x;}
//    }

    public static void main(String[] args) {

        String s = "25525511135";

        List<String> res = restoreIpAdresses(s);

        for(String str: res){
            System.out.println(str);
        }

    }

    public static List<String> restoreIpAdresses(String s){
        List<String> res = new ArrayList<>();

        if(s.length()==0 || s.length()>12) return res;

        int[] path = new int[3];

        Dfs(res, path, 0, 0, s);

        return res;
    }

    public static void Dfs(List<String> res, int[] path, int order, int idx, String s){
        if(order==3){
            if(valid(s.substring(idx))){
                res.add(s.substring(0, path[0]) + '.'
                 +s.substring(path[0], path[1]) + '.'
                 +s.substring(path[1], path[2]) + '.'
                 +s.substring(path[2]));
            }
            return;
        }

        for(int i = 1; i<4; i++){
            if(idx+i>=s.length()) break;
            if(!valid(s.substring(idx, idx+i))) break;
            path[order] = idx+i;
            Dfs(res, path, order+1, idx+i, s);
        }

    }

    public static boolean valid(String s){

        return !(s.length()==0 ||
                 s.length()>3 ||
                (s.length()>1 && s.charAt(0) == '0') ||
                Integer.valueOf(s) > 255);
    }
}
