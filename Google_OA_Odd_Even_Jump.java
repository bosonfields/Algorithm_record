    public int oddEvenJumps(int[] A) {
        if(A == null || A.length == 0) return 0;
        
        int[][] A_idx = new int[A.length][2];
        
        for(int i = 0; i < A.length; i++){
            A_idx[i][0] = A[i];
            A_idx[i][1] = i;
        }
        
        Arrays.sort(A_idx, Comparator.comparing(a -> a[0]));
        
        Stack<Integer> st = new Stack<>();
        int[] idx_odd = new int[A.length];
        int[] idx_even = new int[A.length];
        
        for(int[] ele : A_idx){
            while(!st.isEmpty() && st.peek() < ele[1]){
                idx_odd[st.pop()] = ele[1];
            }
            st.push(ele[1]);
        }
        
        st = new Stack<>();
        
        Arrays.sort(A_idx, Comparator.comparing(a -> -a[0]));
        
        for(int[] ele : A_idx){
            while(!st.isEmpty() && st.peek() < ele[1]){
                idx_even[st.pop()] = ele[1];
            }
            st.push(ele[1]);
        }
        
        int[] odd_table = new int[A.length];
        int[] even_table = new int[A.length];
        
        odd_table[A.length - 1] = 1; 
        even_table[A.length - 1] = 1;
        
        for(int i = A.length - 2; i >= 0; i--){
            odd_table[i] = even_table[idx_odd[i]];
            even_table[i] = odd_table[idx_even[i]];
        }
        
        int sum = 0;
        for(int i : odd_table){
            sum += i;
        }
        return sum;
    }