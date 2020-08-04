//给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 
//
// 说明：每次只能向下或者向右移动一步。 
//
// 示例: 
//
// 输入:
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 7
//解释: 因为路径 1→3→1→1→1 的总和最小。
// 
// Related Topics 数组 动态规划


package com.lvwei.leetcode.editor.cn;
public class MinimumPathSum{
  public static void main(String[] args) {
       Solution solution = new MinimumPathSum().new Solution();
       int[][] grid = new int[][]{
               new int[]{1, 3, 1},
               new int[]{1, 5, 1},
               new int[]{4, 2, 1}
       };
      System.out.println(solution.minPathSum(grid));

  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null) return 0;
        if (grid[0] == null) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[2][n+1];
        for (int i = 1; i <= m; i++){
            dp[i % 2][0] = Integer.MAX_VALUE;
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = Integer.MAX_VALUE;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if ( i == 1 && j == 1) {
                    dp[i % 2][j] = grid[i-1][j-1];
                } else {
                    dp[i % 2][j] = grid[i-1][j-1] + Math.min(dp[(i-1) % 2][j], dp[i % 2][j - 1]);
                }
            }
        }
        return dp[m % 2][n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}



  