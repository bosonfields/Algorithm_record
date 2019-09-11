package leet_test;

        import org.omg.PortableInterceptor.INACTIVE;

        import javax.swing.plaf.synth.SynthTextAreaUI;
        import java.util.*;
        import java.util.regex.Pattern;


public class Main {


//    public static class ListNode{
//        int val;
//        ListNode next;
//        ListNode(int x) {val=x;}
//    }

    public static void main(String[] args) {
        String path = "/a//b////c/d//././/..";
        String ans = simplifyPath(path);
        System.out.println(ans);
    }

    public static String simplifyPath(String path){
        if(path.length()<2) return "/";

        StringBuilder res = new StringBuilder();
        StringBuilder curr = new StringBuilder();
        LinkedList<String> tmp = new LinkedList<>();

        for(char c: path.toCharArray()){
            if(c=='/' && curr.length()>0){
                tmp.add(curr.toString());
                curr = new StringBuilder();
            }else if(c!='/'){
                curr.append(c);
            }
        }
        if(curr.length()>0) tmp.add(curr.toString());

        int i=0;

        while(i<tmp.size()){
            if(tmp.get(i).equals("..")){
                tmp.remove(i);
                if(i>0){
                    i--;
                    tmp.remove(i);
                }
            }
            else if(tmp.get(i).equals(".")) tmp.remove(i);
            else i++;
        }
        if(tmp.isEmpty()) return "/";
        else{
            for (String s: tmp) res.append("/" + s);
        }

        return res.toString();
    }
}
