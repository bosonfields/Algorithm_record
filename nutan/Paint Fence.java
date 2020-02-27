    public static void main(String[] args) {
        int n = 5;
        int[] arr = {1,0,1,0,1};
        System.out.println(partition(n, arr));
    }
    public static int partition(int n, int[] arr){
        int res = 1;

        int l = 0, r = n - 1;

        while(l < r && arr[l] == 0){
            l++;
        }

        while(l < r && arr[r] == 0){
            r--;
        }

        if(l == r){
            if(arr[l] == 1) return 1;
            return 0;
        }

        int count = 0;

        while(l <= r){
            if(arr[l] == 1){
                res *= count + 1;
                count = 0;
            }
            else count++;
            l++;
        }
        return res;
    }