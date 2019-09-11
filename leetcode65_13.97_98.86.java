package leet_test;

        import org.omg.PortableInterceptor.INACTIVE;
        import java.util.*;
        import java.util.regex.Pattern;


public class Main {


//    public static class ListNode{
//        int val;
//        ListNode next;
//        ListNode(int x) {val=x;}
//    }

    public static void main(String[] args) {
        String s = "+.1 ";

        boolean ans = isNumber(s);
        System.out.println(ans);
    }

    public static boolean isNumber(String s){
        s = s.trim();
        return Pattern.matches("(\\+|-)?(\\d+(\\.\\d*)?|\\.\\d+)(e(\\+|-)?\\d+)?",s);
    }
}