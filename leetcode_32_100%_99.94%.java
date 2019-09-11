package leet_test;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String s = "()()()()())()())";
        int res = longestValidParentheses(s);
        System.out.println(res);
    }
    public static int longestValidParentheses(String s){
        int len = s.length();
        char left = '(';
        char right = ')';
        int max = 0;
        int[] f = new int[s.length()+1];
        for(int i=2; i<=len; i++){
            if(s.charAt(i-1) == right){
                System.out.println("mark");
                System.out.println(i);
                System.out.println(f[i-1]);
                System.out.println(i-f[i-1]-2);
                if(s.charAt(i-2) == left){
                    f[i] = f[i-2] + 2;
                }else if(i - f[i-1] -2 >=0 && s.charAt(i-f[i-1]-2) == '('){
                    f[i] = f[i-1] +2 + f[i-f[i-1]-2];
                }
            }
            max = Math.max(max, f[i]);
        }
        return max;
    }
}


