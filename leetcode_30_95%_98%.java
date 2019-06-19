package leet_test;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String s = "wordgoodgoodgoodbestword";
        String[] words = new String[]{"word","good","best","good"};

        List<Integer> output = findSubstring(s, words);
        System.out.println(Arrays.toString(output.toArray()));
    }
    public static List<Integer> findSubstring(String s, String[] words){
        if(s.isEmpty() || words.length==0) return new ArrayList<>();

        int wnums = words.length;
        int elen = words[0].length();

        if(wnums * elen>s.length()) return new ArrayList<>();

        int plus;
        HashMap<String, Integer> map = new HashMap<>();
        for(String w: words){
            if(!map.containsKey(w)) map.put(w, 1);
            else{
                plus = map.get(w) + 1;
                map.put(w, plus);
            }
        }

        List<Integer> res = new ArrayList<>();

        int sCap = s.length() - elen+1;
        int head;
        int count;
        int eCount;
        String sHead;

        for(int i=0 ; i<elen ; i++){
            head = i;
            count = 0;
            HashMap<String, Integer> currMap = new HashMap<>();

            for(int j = i; j<sCap; j+=elen){
                String currStr = s.substring(j, j+elen);
                System.out.println("sCurr:"+currStr);


                if(map.containsKey(currStr)){
                    eCount = currMap.getOrDefault(currStr, 0)+1;
                    currMap.put(currStr, eCount);
                    count+=1;
                    if(currMap.get(currStr)>map.get(currStr)){
                        boolean flag = true;
                        while(flag){
                            sHead = s.substring(head, head+elen);

                            System.out.println("shead:"+sHead);

                            currMap.put(sHead, currMap.get(sHead)-1);
                            count--;
                            head+=elen;
                            if(sHead.equals(currStr)) flag = false;
                        }
                    }

                    if(count==wnums){
                        res.add(head);
                        sHead = s.substring(head, head+elen);
                        currMap.put(sHead, currMap.get(sHead)-1);
                        count-=1;
                        head+=elen;
                    }

                }else{
                    currMap.clear();
                    head = j+elen;
                    count =0;
                }
            }
        }
        return res;
    }
}


