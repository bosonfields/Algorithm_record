    public int[][] kClosest(int[][] points, int K) {
        if(K == points.length) return points;
        
        partition(points, 0, points.length - 1, K);
        
        int[][] res = Arrays.copyOfRange(points, 0, K);
        
        return res;
    }
    public void partition(int[][] points, int start, int end, int K){

        if(end <= start) return;
        double pivot = dist2origin(points[end]);
        
        int j = start;
        
        for(int i = start; i < end; i++){
            if(dist2origin(points[i]) < pivot){
                swap(points, j, i);
                j += 1;
            }
        }
        
        swap(points, j, end);
        
        if(j == K - 1) return;
        
        if(j < K - 1){
            partition(points, j + 1, end, K);
        }
        else{
            partition(points, start, j - 1, K);
        }
    }
    
    public double dist2origin(int[] point){
        return point[0] * point[0] + point[1] * point[1];
    }
    public void swap(int[][] points, int a, int b){
        int[] tmp = points[a];
        points[a] = points[b];
        points[b] = tmp;
    }