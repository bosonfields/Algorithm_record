package leet_test;

        import org.w3c.dom.ls.LSException;

        import java.util.*;

public class Main {


    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) {val=x;}
    }

    public static void main(String[] args) {
        String s1 = "abcdd";
        String s2 = "dbdac";
        boolean res = isScramble(s1, s2);
        System.out.println(res);
    }

    public static boolean isScramble(String s1, String s2){
        if(s1.equals(s2)) return true;

        if(s1.length()!=s2.length()) return false;

        int[] arr = new int[26];
        char[] s1C = s1.toCharArray();
        char[] s2C = s2.toCharArray();

        for(int i=0; i<s1.length(); i++){
            arr[s1C[i]-'a']++;
            arr[s2C[i]-'a']--;
        }
        for(int c: arr){
            if(c!=0) return false;
        }

        for(int i=1; i<s1.length(); i++){
            if(isScramble(s1.substring(0,i), s2.substring(0,i)) && isScramble(s1.substring(i), s2.substring(i))) return true;

            if(isScramble(s1.substring(0,i), s2.substring(s2.length()-i)) && isScramble(s1.substring(i), s2.substring(0, s2.length()-i))) return true;
        }
        return false;
    }
}
