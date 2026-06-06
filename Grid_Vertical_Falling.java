import java.util.Scanner;

/**
 * Text/Folder Name: Grid_Vertical_Falling
 * Description: Maximum Falling Path Sum (Non-Adjacent Columns)
 */
public class Grid_Vertical_Falling { // ROW - WISE FALLING, CANNOT FALL IN SAME COLUMN

    public static int getMaximumFallingSum(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        
        if (r == 1 && c == 1) return grid[0][0];
        
        int[] prevDP = new int[c];
        for (int j = 0; j < c; j++) {
            prevDP[j] = grid[0][j];
        }
        
        for (int i = 1; i < r; i++) {
            int[] currDP = new int[c];
            int max1 = Integer.MIN_VALUE;
            int max2 = Integer.MIN_VALUE;
            int maxIndex = -1;
            
            for (int j = 0; j < c; j++) {
                if (prevDP[j] > max1) {
                    max2 = max1;
                    max1 = prevDP[j];
                    maxIndex = j;
                } else if (prevDP[j] > max2) {
                    max2 = prevDP[j];
                }
            }
            
            for (int j = 0; j < c; j++) {
                if (maxIndex == j) {
                    currDP[j] = grid[i][j] + max2;
                } else {
                    currDP[j] = grid[i][j] + max1;
                }
            }
            prevDP = currDP;
        }

        int maxPathSum = Integer.MIN_VALUE;
        for (int val : prevDP) {
            maxPathSum = Math.max(maxPathSum, val);
        }
        
        return maxPathSum;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int r = scan.nextInt();
        int c = scan.nextInt();
        
        int[][] grid = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                grid[i][j] = scan.nextInt();
            }
        }
        
        System.out.println(getMaximumFallingSum(grid));
        scan.close();
    }
}
