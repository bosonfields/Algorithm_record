    public int minDominoRotations(int[] A, int[] B) {
        if(A == null || A.length == 0) return 0;
        if(B == null || B.length == 0) return 0;
        
        int countA = helper(A[0], A, B);
        int countB = helper(B[0], A, B);
        
        if(countA == -1) return countB;
        if(countB == -1) return countA;
        
        return Math.min(countA, countB);
        
    }
    public int helper(int pivot, int[] A, int[] B){
        int swapToA = 0, swapToB = 0;
        
        int idx = 0;
        
        while(idx < A.length && (A[idx] == pivot || B[idx] == pivot)){
            if(A[idx] != pivot) swapToA++;
            if(B[idx] != pivot) swapToB++;
            idx++;
        }
        
        if(idx < A.length) return -1;
        
        return Math.min(swapToA, swapToB);
    }