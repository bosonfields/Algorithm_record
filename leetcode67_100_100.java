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
        String a ="11";
        String b = "1";
        String ans = addBinary(a, b);
        System.out.println(ans);
    }

    public static String addBinary(String a, String b){
        if(a.length()==0) return b;
        if(b.length()==0) return a;
        char[] m = (a.length()>b.length()? a:b).toCharArray();
        char[] n = (a.length()>b.length()? b:a).toCharArray();
        StringBuilder tmp = new StringBuilder();

        int i = 0;
        int curr =0;
        int carr = 0;
        while(i<m.length){
            curr = m[m.length-i-1]-'0'+carr + (i<n.length? n[n.length-i-1]-'0':0);

            if(curr>1){
                carr=1;
                tmp.append(curr-2);
            }else{
                carr=0;
                tmp.append(curr);
            }
            i++;
        }

        if(carr!=0) tmp.append(1);

        return tmp.reverse().toString();
    }
}