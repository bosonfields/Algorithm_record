package leet_test;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        double x = 2.0;
        int n = -2;

        double res = myPow(x, n);

        System.out.println(res);

    }
    public static double myPow(double x, int n){
        if(n==0) return 1;
        if(n==Integer.MIN_VALUE){
            x = x * x;
            n=n/2;
        }
        if(n<0){
            n=-n;
            x = 1/x;
        }
        return (n%2 == 0) ? myPow(x*x, n/2) : x*myPow(x*x,n/2);
    }
}