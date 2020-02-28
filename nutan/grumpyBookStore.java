    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int n = customers.length;
        int[] unsatisfied = new int[n];
        int totalSatisfy = 0;
        
        for(int i = 0; i < n; i++){
            if(grumpy[i] == 1) unsatisfied[i] = customers[i];
            else totalSatisfy += customers[i];
        }        
        int currChanged = 0, idx = 0, count = 0, maxChanged = 0;
        while(idx <= n){
            while(idx < n && count < X){
                currChanged += unsatisfied[idx];
                idx++; count++;
            }
            maxChanged = Math.max(maxChanged, currChanged);
            if(idx >= n) break;
            currChanged += -unsatisfied[idx - X] + unsatisfied[idx];
            idx++;
        }
        return totalSatisfy + maxChanged;
    }