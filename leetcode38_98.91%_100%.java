package leet_test;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int n = 5;
        String res = countAndSay(n);
        System.out.println(res);
    }
    public static String countAndSay(int n){
        String s = "1";
        for(int i=1; i<n; i++){
            s = nextSay(s);
        }
        return s;
    }
    public static String nextSay(String s){
        StringBuilder sb = new StringBuilder();
        char curr = s.charAt(0);
        int count = 1;
        for(int j = 1; j<s.length(); j++){
            if(s.charAt(j) == curr) count+=1;
            else{
                sb.append(count);
                sb.append(curr);
                curr = s.charAt(j);
                count = 1;
            }
        }
        sb.append(count);
        sb.append(curr);
        return sb.toString();
    }
}