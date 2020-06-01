import java.util.ArrayList;
import java.util.List;


public class Solution51 {

    private List<List<String>> results;
    private boolean[] cols;
    private boolean[] diag1;
    private boolean[] diag2;
    
    public List<List<String>> solveNQueens(int n) {
        
        results = new ArrayList<>();
        
        if (n==0)
            return results;
        
        cols = new boolean[n];
        diag1 = new boolean[2*n-1];
        diag2 = new boolean[2*n-1];
        int[] method = new int[n];
        
        solveNQueuesCore(method, 0, n);
        
        return results;
    }
    private void solveNQueuesCore(int[] method, int row, int n) {
        if (row == n) {
            List<String> res = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder builder = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (j==method[i]) {
                        builder.append('Q');
                    }
                    else {
                        builder.append('.');
                    }
                }
                res.add(builder.toString());
            }
            results.add(res);
        }
        
        for (int col = 0; col < n; col++) {
            if (!cols[col]) {
                int sum = row+col;
                int substract = row-col;
                if (!diag1[sum] && !diag2[substract+n-1]) {
                    method[row] = col;
                    cols[col] = true;
                    diag1[sum] = true;
                    diag2[substract+n-1] = true;
                    solveNQueuesCore(method, row+1, n);
                    cols[col] = false;
                    diag1[sum] = false;
                    diag2[substract+n-1] = false;
                }
            }
        }
        
        return;
    }
}