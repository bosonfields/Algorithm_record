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

        String[] words = {"Listen","to","many,","speak","to","a","few."};
        int maxWidth = 6;

        List<String> ans = fullJustify(words, maxWidth);
        for(String s: ans){
            System.out.println(s);
        }
    }

    public static List<String> fullJustify(String[] words, int maxWidth){
        List<String> ans = new ArrayList<>();
        if(words.length==0) return ans;
        int j=0;
        int sum = words[0].length();
        int wordsLen = words[0].length();

        for(int i =1; i<words.length; i++){
            sum+=words[i].length() + 1;
            if(sum>maxWidth){
                ans.add(packOne(j, i-1, wordsLen, maxWidth, words));
                j=i;
                sum=words[j].length();
                wordsLen=0;
            }
            wordsLen+=words[i].length();
        }

        StringBuilder las = new StringBuilder();
        while(las.length()<maxWidth){
            if(j<words.length){
                las.append(words[j]);
            }
            if(las.length()==maxWidth) break;
            las.append(" ");
            j++;
        }
        ans.add(las.toString());

        return ans;
    }
    public static String packOne(int start, int end, int wordslen, int maxWidth, String[] words){

        StringBuilder res = new StringBuilder();
        if(end==start){
            res.append(words[start]);
            res.append(genBlk(maxWidth-words[start].length()));
            return res.toString();
        }

        int sBlank = (maxWidth-wordslen)/(end-start);
        int modBlank = (maxWidth-wordslen)%(end-start);

        String sbl = genBlk(sBlank);

        for(int i = start; i<end; i++){
            if (modBlank>0){
                res.append(words[i]);
                res.append(sbl);
                res.append(" ");
                modBlank--;
            }
            else res.append(words[i] + sbl);
        }
        res.append(words[end]);
        return res.toString();
    }
    public static String genBlk(int nums){
        if(nums==0) return "";
        if(nums==1) return " ";
        return nums%2==0? genBlk(nums/2) + genBlk(nums/2): genBlk((nums-1))+" ";
    }
}