    public static void main(String[] args) {
        char[][] board = {
                {'D','A','A','A'},
                {'A','A','C','A'},
                {'A','E','F','A'},
                {'A','A','A','A'}
        };
        System.out.println(findCircle(board));
    }
    private static int[] r_bias = {1, -1, 0, 0};
    private static int[] c_bias = {0, 0, 1, -1};

    public static boolean findCircle(char[][] board) {
        if(board.length == 0 || board[0].length == 0) return false;
        int n = board.length;
        int m = board[0].length;

        boolean[][] visited = new boolean[n][m];

        for(int i = 0 ; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!visited[i][j] && Dfs(board, visited, i, j, -1, -1)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean Dfs(char[][] board, boolean[][] visited,
                              int curr_r, int curr_c, int pre_x, int pre_y){
        int n = board.length;
        int m = board[0].length;
        char color = board[curr_r][curr_c];

        for(int i = 0; i < r_bias.length; i++){
            int next_r = curr_r + r_bias[i];
            int next_c = curr_c + c_bias[i];

            if(!inBound(n, m, next_r, next_c, pre_x, pre_y) || board[next_r][next_c] != color){
                continue;
            }

            if(visited[next_r][next_c]){
                return true;
            }

            visited[next_r][next_c] = true;
            Dfs(board, visited, next_r, next_c, curr_r, curr_c);
        }

        return false;
    }
    private static boolean inBound(int n, int m, int x, int y, int pre_x, int pre_y){

        return x >= 0 && x < n
                && y >= 0 && y < m
                && (x != pre_x || y != pre_y);
    }