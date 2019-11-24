    public static void main(String[] args) {
        int[] roses = {1, 2, 4, 9, 3, 4, 1};
        int k = 2, n = 4;
        int res = miniDaysBloom(roses, k, n);
        System.out.println(res);
    }
    public static int miniDaysBloom(int[] roses, int k, int n){
        if(roses == null || roses.length == 0) return (n * k) == 0 ? 0 : -1;
        int s = Integer.MAX_VALUE, e = -1;
        for(int bloom : roses){
            e = Math.max(e, bloom);
            s = Math.min(s, bloom);
        }
        while(s + 1 < e){
            int mid = s + (e - s) / 2;
            if(isCompensate(roses, mid, k, n)){
                e = mid;
            }else{
                s = mid;
            }
        }
        if(!isCompensate(roses, e, k, n)) return -1;
        return e;
    }
    public static boolean isCompensate(int[] roses, int day, int k, int n){
        int curr_adj = 0, bq_sum = 0;
        for(int i = 0; i < roses.length && bq_sum < n; i++){
            if(roses[i] > day){
                curr_adj = 0;
                continue;
            }
            curr_adj++;
            if(curr_adj == k){
                bq_sum++;
                curr_adj = 0;
            }
        }
        return bq_sum >= n;
    }