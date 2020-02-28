    public static void main(String[] args) {
        String s = "0000011";
        int pairWeight = 4;
        int singleWeight = 1;
        int toggle = 1;
        System.out.println(maxWeight(s, pairWeight, singleWeight, toggle));
    }
    public static int maxWeight(String s, int pairWeight, int singleWeight, int toggle){
        int[] dp = new int[s.length() + 1];
        char[] sArr = s.toCharArray();
        dp[1] = singleWeight;

        for(int i = 1; i < sArr.length; i++){
            int tmp = -1;
            if(sArr[i] != sArr[i - 1]){
                tmp = Math.max(dp[i - 1] + pairWeight, tmp);
            }
            else{
                tmp = Math.max(dp[i - 1] + pairWeight - toggle, tmp);
            }
            tmp = Math.max(dp[i] + singleWeight, tmp);
            dp[i + 1] = tmp;
        }

        return dp[sArr.length];
    }