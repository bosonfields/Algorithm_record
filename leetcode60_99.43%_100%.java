package leet_test;

        import org.omg.PortableInterceptor.INACTIVE;

        import java.util.*;

public class Main {
    public static void main(String[] args) {
        int n = 4;
        int k = 9;
        String ans = getPermutation(n, k);
        System.out.println(ans);

    }

    public static String getPermutation(int n, int k){
        StringBuilder sb = new StringBuilder();
        int fac = 1;

        List<Integer> ls = new LinkedList<>();

        for(int i =1; i<n; i++){
            fac *= i;
            ls.add(i);
        }
        ls.add(n);

        k-=1;

        int sub= n-1;

        while(!ls.isEmpty()){
            if(k!=0){
                sb.append((char)(ls.remove(k/fac) + '0'));
                k%=fac;
                if(fac!=1) fac/=sub;
                sub-=1;
            }
            else sb.append((char)(ls.remove(0)+'0'));
        }
        return sb.toString();
    }
}