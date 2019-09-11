package leet_test;

        import org.omg.PortableInterceptor.INACTIVE;

        import java.util.*;

public class Main {
    public static void main(String[] args) {
        String s = "Hello World";
        int ans = lengthOfLastWord(s);
        System.out.println(ans);
    }

    public static int lengthOfLastWord(String s){
        int res = 0;

        if(s.length()==0) return 0;

        int i = s.length()-1;

        while(i>=0 && s.charAt(i) == ' ') i--;

        for(; i>=0 && s.charAt(i)!=' '; i--){
            res+=1;
        }
        return res;
    }
}