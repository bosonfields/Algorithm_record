    public static void main(String[] args) {
        String[] input = {"+1A", "+3E", "-1A", "+4F", "-3E"};
        List<String> res = mostBooked(input);
        for(String s : res){
            System.out.println(s);
        }
    }
    public static List<String> mostBooked(String[] seq){
        int[] record = new int[260];
        boolean[] notFree = new boolean[260];
        int max = 0;
        for(int i = 0; i < seq.length; i++){
            int curr = countIdx(seq[i], notFree);
            if(curr == -1) continue;
            record[curr]++;
            max = Math.max(max, record[curr]);
        }
        List<String> res = new ArrayList<>();
        for(int i = 0; i < record.length; i++){
            if(record[i] == max){
                res.add(idxToStr(i));
            }
        }
        return res;
    }
    public static int countIdx(String s, boolean[] notFree){
        char[] sArr = s.toCharArray();
        int idx =  (sArr[1] - '0') * 26 + sArr[2] - 'A';

        if(sArr[0] == '+' && !notFree[idx]){
            notFree[idx] = true;
            return idx;
        }
        if(sArr[0] == '-'){
            notFree[idx] = false;
        }
        return -1;
    }
    public static String idxToStr(int num){
        char[] curr = new char[2];
        curr[0] = (char)(num / 26 + '0');
        curr[1] = (char)(num % 26 + 'A');
        return new String(curr);
    }