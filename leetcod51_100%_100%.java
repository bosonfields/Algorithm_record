package leet_test;

        import org.omg.PortableInterceptor.INACTIVE;

        import java.util.*;

public class Main {
    public static void main(String[] args) {
        int n = 4;
        List<List<String>> ans = solveNQueens(n);

        System.out.println(ans.toString());

     }
    public static List<List<String>> solveNQueens(int n){
        if(n==0) return null;

        List<List<String>> boards = new ArrayList<>();

        char[][] bd = new char[n][n];

        for(char[] c : bd){
            Arrays.fill(c, '.');
        }

        boolean[] banArr = new boolean[5 * n -2];

        Dfs(boards, bd, banArr, 0, 0);

        return boards;
    }
    public static void Dfs(List<List<String>> boards, char[][] bd, boolean[] banArr, int row, int count){
        int n = bd.length;
        if(count== n){
            List<String> tmp = new ArrayList<>();
            for(char[] c: bd){
                tmp.add(new String(c));
            }
            boards.add(tmp);
            return;
        }

        for(int i=0; i<n; i++){
            if(!banArr[i] && !banArr[row-i+2 * n -1] && !banArr[row + i + 3 * n -1]){
                banArr[i] = true;
                banArr[row-i+2 * n -1] = true;
                banArr[row + i +3 *n -1] = true;
                bd[row][i] = 'Q';
                Dfs(boards, bd, banArr, row+1, count+1);
                bd[row][i] = '.';
                banArr[i] = false;
                banArr[row-i + 2 * n -1] = false;
                banArr[row + i +3 *n -1] = false;
            }
        }
        return;
    }
}