package leet_test;

        import java.util.*;

public class Main {


//    public static class ListNode{
//        int val;
//        ListNode next;
//        ListNode(int x) {val=x;}
//    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String ans = minWindow(s, t);
        System.out.println(ans);
    }

    public static String minWindow(String s, String t){
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        int sLen = s.length(), tLen = t.length();

        if(sLen==0 || tLen==0 || sLen<tLen) return "";

        int i =0, j=0, count = tLen;
        int rleft =0, rright = s.length();
        int min= s.length();

        boolean flag = false;
        int[] map = new int[128];

        for(char c: tArr){
            map[c]+=1;
        }

        while(j<sLen){
            if(map[sArr[j]]>0) count--;
            map[sArr[j]]--; j++;
            while(count==0){
                flag = true;
                if(min>j-i){
                    min = j-i;
                    rleft = i;
                    rright = j;
                }
                if(++map[sArr[i++]]>0) count++;
            }
        }

        return flag ? s.substring(rleft, rright) : "";
    }
}
