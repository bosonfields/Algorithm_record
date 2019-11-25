    public static void main(String[] args) {
        int[] S = {1,2,6,5,3};
        int[] E = {5,5,7,6,8};

        int res = miniChairs(S, E);

        System.out.println(res);
    }
    public static int miniChairs(int[] S, int[] E){
        Arrays.sort(S);
        Arrays.sort(E);

        int res = 0;
        int curr = 0;

        int sIdx = 0, eIdx = 0;

        while(sIdx < S.length){
            if(S[sIdx] < E[eIdx]){
                curr += 1;
                sIdx += 1;
                res = Math.max(curr, res);
            }else{
                eIdx += 1;
                curr -= 1;
            }
        }

        return res;
    }