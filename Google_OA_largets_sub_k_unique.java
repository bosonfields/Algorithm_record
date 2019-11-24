    public static void main(String[] args) {
        int[] A = {1,4,3,2,5};

        int[] res = largestSubArr(A, 3);

        System.out.println(Arrays.toString(res));

    }
    public static int[] largestSubArr(int[] arr, int K){
        int[] res = new int[K];

        int start = 0;

        for(int i = 1; i < arr.length - K + 1; i++){
            if(arr[start] < arr[i]){
                start = i;
            }
        }

        for(int i = 0; i < K; i++){
            res[i] = arr[start + i];
        }

        return res;
    }