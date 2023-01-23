import java.util.*;
import java.util.Queue;

public class RottingOranges {

    public static void main(String[] args) {
        int[][] input = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(orangesRotting(input));
    }


    public static int orangesRotting(int[][] grid) {
        Queue<List<Integer>> queue = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 2) {
                    queue.add(Arrays.asList(i, j));
                }
                if(grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        int level = 0;
        while(queue.size() > 0 && fresh != 0) {
            int len = queue.size();
            while(len > 0) {
                List<Integer> popped = queue.poll();
                int r = popped.get(0);
                int c = popped.get(1);
                if(r - 1 >= 0 && grid[r - 1][c] == 1) {
                    grid[r - 1][c] = 2;
                    fresh--;
                    queue.add(Arrays.asList(r - 1, c));
                }
                if(r + 1 < m && grid[r + 1][c] == 1) {
                    grid[r + 1][c] = 2;
                    fresh--;
                    queue.add(Arrays.asList(r + 1, c));
                }
                if(c - 1 >= 0 && grid[r][c - 1] == 1) {
                    grid[r][c - 1] = 2;
                    fresh--;
                    queue.add(Arrays.asList(r, c - 1));
                }
                if(c + 1 < n && grid[r][c + 1] == 1) {
                    grid[r][c + 1] = 2;
                    fresh--;
                    queue.add(Arrays.asList(r, c + 1));
                }
                len--;
            }
            level++;
        }
        return fresh == 0 ? level : -1;
    }
    
}
