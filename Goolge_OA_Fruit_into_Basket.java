    public int totalFruit(int[] tree) {
        
        if(tree == null || tree.length == 0) return 0;
        
        int left = 0, right = 0;
        
        while(right < tree.length && tree[right] == tree[left]){
            right++;
        }
        
        if(right == tree.length) return tree.length;
        
        int res = right - left + 1;
        int curr = res;
        int idx = right + 1;
                
        while(idx < tree.length){
            if(tree[idx] == tree[left] || tree[idx] == tree[right]){
                curr++;
            }else{
                right = idx;
                left = idx - 1;
                while(tree[left - 1] == tree[idx - 1]){
                    left--;
                }
                curr = idx - left + 1;
            }
            idx++;
            res = Math.max(res, curr);
        }
        
        return res;
    }