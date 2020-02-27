    public static void main(String[] args) {
        int[] A = {1, 1, 0, 2, 4};

        int[] res = largestSubArr(A, 3);

        System.out.println(Arrays.toString(res));

    }
    public static int[] largestSubArr(int[] arr, int K){
        int[] res = new int[K];

        int start = 0;

        for(int i = 1; i < arr.length - K + 1; i++){
            int j = 0;
            while(j < K && arr[i + j] == arr[start + j]){
                j++;
            }
            if(j < K && arr[i + j] > arr[start + j]){
                start = i;
            }
        }

        for(int i = 0; i < K; i++){
            res[i] = arr[start + i];
        }

        return res;
    }