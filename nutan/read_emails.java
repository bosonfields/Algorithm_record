    public static void main(String[] args) {
        int[] arr = {1,1,0,0,1};
        System.out.println(readAll(arr));
    }
    public static int readAll(int[] emails){
        if(emails.length == 0) return 0;
        int n = emails.length;
        int[] dp = new int[n];
        dp[0] = emails[0] == 1 ? 1 : 0;

        for(int i = 1; i < n; i++){
            if(emails[i] == 1){
                dp[i] = dp[i - 1] + 1;
            }
            else{
                dp[i] = dp[i - 1];
                dp[i] += emails[i - 1] == 1 ? 1 : 0;
            }
        }

        if(emails[n - 1] == 0) dp[n - 1] -= 1;
        
        return dp[n - 1];
    }