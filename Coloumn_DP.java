import java.util.Scanner;
public class Coloumn_DP { // COLOUMN - WISE WALKING, CANNOT WALK IN SAME ROW

    public static int getMaximumHorizontalSum(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        
        // Edge case: If there is only one cell, return its value
        if (r == 1 && c == 1) return grid[0][0];
        
        // Tracking array size matches total ROWS (r)
        int[] prevDP = new int[r];
        for (int i = 0; i < r; i++) {
            prevDP[i] = grid[i][0]; // Base case: First column values
        }
        
        // Outer loop: Columns (Moving Left to Right starting at Column 1)
        for (int j = 1; j < c; j++) {
            int[] currDP = new int[r];
            int max1 = Integer.MIN_VALUE;
            int max2 = Integer.MIN_VALUE;
            int maxIndex = -1;
            
            // Extract the top two maximum values from the left column results
            for (int i = 0; i < r; i++) {
                if (prevDP[i] > max1) {
                    max2 = max1;
                    max1 = prevDP[i];
                    maxIndex = i;
                } else if (prevDP[i] > max2) {
                    max2 = prevDP[i];
                }
            }
            
            // Inner loop: Rows
            for (int i = 0; i < r; i++) {
                if (maxIndex == i) {
                    currDP[i] = grid[i][j] + max2; // Row clash backup choice
                } else {
                    currDP[i] = grid[i][j] + max1; // Safe optimal choice
                }
            }
            prevDP = currDP; // Move step forward
        }

        // Search the final iteration space for the peak path sum
        int maxPathSum = Integer.MIN_VALUE;
        for (int val : prevDP) {
            maxPathSum = Math.max(maxPathSum, val);
        }
        
        return maxPathSum;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        // Read grid dimensions
        int r = scan.nextInt();
        int c = scan.nextInt();
        
        int[][] grid = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                grid[i][j] = scan.nextInt();
            }
        }
        
        // Execute and display result
        System.out.println(getMaximumHorizontalSum(grid));
        scan.close();
    }
}
