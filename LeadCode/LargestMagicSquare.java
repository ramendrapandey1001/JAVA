package LeadCode;
/*
A k x k magic square is a k x k grid filled with integers such that every row sum, every column sum, and both diagonal sums are all equal. The integers in the magic square do not have to be distinct. Every 1 x 1 grid is trivially a magic square.

Given an m x n integer grid, return the size (i.e., the side length k) of the largest magic square that can be found within this grid.

 

Example 1:


Input: grid = [[7,1,4,5,6],[2,5,1,6,4],[1,5,4,3,2],[1,2,7,3,4]]
Output: 3
Explanation: The largest magic square has a size of 3.
Every row sum, column sum, and diagonal sum of this magic square is equal to 12.
- Row sums: 5+1+6 = 5+4+3 = 2+7+3 = 12
- Column sums: 5+5+2 = 1+4+7 = 6+3+3 = 12
- Diagonal sums: 5+4+3 = 6+4+2 = 12
Example 2:


Input: grid = [[5,1,3,1],[9,3,3,1],[1,3,3,8]]
Output: 2
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 50
1 <= grid[i][j] <= 106
 */
public class LargestMagicSquare {

	public static void main(String[] args) {
		
		int [] [] grid = {{7,1,4,5,6},{2,5,1,6,4},{1,5,4,3,2},{1,2,7,3,4}};
		System.out.println(largestMagicSquare(grid));
	}

	public static int largestMagicSquare(int[][] grid) {
        int totalRows = grid.length;
        int totalCols = grid[0].length;

        // Precompute prefix sums to quickly get the sum of any row or column segment
        // rowPrefixSums[i][j] = sum of elements in row i from column 0 to j-1
        int[][] rowPrefixSums = new int[totalRows][totalCols + 1];
        int[][] colPrefixSums = new int[totalCols][totalRows + 1];

        for (int row = 0; row < totalRows; row++) {
            for (int col = 0; col < totalCols; col++) {
                rowPrefixSums[row][col + 1] = rowPrefixSums[row][col] + grid[row][col];
                colPrefixSums[col][row + 1] = colPrefixSums[col][row] + grid[row][col];
            }
        }

        // Try the largest possible side length 'k' and work downwards (Greedy)
        for (int sideLength = Math.min(totalRows, totalCols); sideLength > 1; sideLength--) {
            // Iterate through every possible top-left corner (startRow, startCol)
            for (int startRow = 0; startRow <= totalRows - sideLength; startRow++) {
                for (int startCol = 0; startCol <= totalCols - sideLength; startCol++) {
                    
                    if (isMagicSquare(grid, startRow, startCol, sideLength, rowPrefixSums, colPrefixSums)) {
                        return sideLength;
                    }
                }
            }
        }

        return 1; // Every 1x1 cell is technically a magic square
    }

    private static boolean isMagicSquare(int[][] grid, int startRow, int startCol, int side, 
                                 int[][] rowPrefixSums, int[][] colPrefixSums) {
        
        // Calculate the sum of the first row to use as our target sum
        int targetSum = rowPrefixSums[startRow][startCol + side] - rowPrefixSums[startRow][startCol];

        // 1. Check all other Rows in the square
        for (int row = startRow + 1; row < startRow + side; row++) {
            int currentRowSum = rowPrefixSums[row][startCol + side] - rowPrefixSums[row][startCol];
            if (currentRowSum != targetSum) return false;
        }

        // 2. Check all Columns in the square
        for (int col = startCol; col < startCol + side; col++) {
            int currentColSum = colPrefixSums[col][startRow + side] - colPrefixSums[col][startRow];
            if (currentColSum != targetSum) return false;
        }

        // 3. Check Main Diagonal (top-left to bottom-right)
        int mainDiagonalSum = 0;
        for (int i = 0; i < side; i++) {
            mainDiagonalSum += grid[startRow + i][startCol + i];
        }
        if (mainDiagonalSum != targetSum) return false;

        // 4. Check Anti-Diagonal (top-right to bottom-left)
        int antiDiagonalSum = 0;
        for (int i = 0; i < side; i++) {
            antiDiagonalSum += grid[startRow + i][startCol + side - 1 - i];
        }

        return antiDiagonalSum == targetSum;
    }
}
