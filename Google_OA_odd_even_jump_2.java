    public int oddEvenJumps(int[] A) {
        int len = A.length;
        
        boolean[] odd_table = new boolean[len];
        boolean[] even_table = new boolean[len];
        
        odd_table[len - 1] = true;
        even_table[len - 1] = true;
        
        TreeMap<Integer, Integer> tmap = new TreeMap<>();
        
        tmap.put(A[len - 1], len - 1);
        
        int res = 1;
        
        for(int i = len - 2; i >= 0; i--){
            Map.Entry nex_odd = tmap.ceilingEntry(A[i]);
            Map.Entry nex_even = tmap.floorEntry(A[i]);
            
            if(nex_odd != null) odd_table[i] = even_table[(int)nex_odd.getValue()];
            if(nex_even != null) even_table[i] = odd_table[(int)nex_even.getValue()];
            
            res += odd_table[i] ? 1 : 0;
            tmap.put(A[i], i);
        }
        return res;
    }