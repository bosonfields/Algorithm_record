    public static void main(String[] args) {
        int n = 8;
        int[] arr = {3, 17, 4, 12, 5, 6, 2, 1};
        System.out.println(beautifyRow(n, arr));
    }
    public static int beautifyRow(int n, int[] arr){
        int[] ltor = new int[n];
        int[] rtol = new int[n];

        increaseNums(ltor, arr);
        decreaseNums(rtol, arr);

        int sameNum = 0;
        for(int i = 0; i < n; i++){
            sameNum = Math.max(sameNum, ltor[i] + rtol[i] - 1);
        }

        return n - sameNum;

    }

    public static void increaseNums(int[] record, int[] arr){
        int n = arr.length;

        record[0] = 1;

        for(int i = 1; i < n; i ++){
            for(int j = 0; j < i; j++){
                if(arr[j] <= arr[i]){
                    record[i] = Math.max(record[i], record[j] + 1);
                }
            }
        }
    }
    public static void decreaseNums(int[] record, int[] arr){
        int n = arr.length;

        record[n - 1] = 1;

        for(int i = n - 2; i >= 0; i --){
            for(int j = n - 1; j > i; j--){
                if(arr[j] <= arr[i]){
                    record[i] = Math.max(record[i], record[j] + 1);
                }
            }
        }
    }
