package leet_test;

import java.util.*;

public class Main {
    public static void main(String[] args) {
       String s = "acdcb";
       String p = "a*c?b";
       System.out.println(isMatch(s,p));

    }
    public static boolean isMatch(String s, String p){
        int indS = 0, indP = 0;

        int saveS = -1, saveP = -1;

        while(indS<s.length()){
            if(indP<p.length() && (s.charAt(indS) == p.charAt(indP) || p.charAt(indP) == '?')){
                indS+=1;
                indP+=1;
            }
            else if(indP<p.length() && p.charAt(indP) =='*'){
                saveP = indP;
                saveS = indS+1;
                indP+=1;
            }
            else if(saveP !=-1){
                indP = saveP;
                indS = saveS;
            }
            else return false;
        }
        for(int i = indP; i<p.length(); i++){
            if(p.charAt(i) != '*') return false;
        }
        return true;
    }
}


