//给定一个非负整数数组，你最初位于数组的第一个位置。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 判断你是否能够到达最后一个位置。 
//
// 示例 1: 
//
// 输入: [2,3,1,1,4]
//输出: true
//解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
// 
//
// 示例 2: 
//
// 输入: [3,2,1,0,4]
//输出: false
//解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
// 
// Related Topics 贪心算法 数组


package com.lvwei.leetcode.editor.cn;
public class JumpGame{
  public static void main(String[] args) {
       Solution solution = new JumpGame().new Solution();
       int[] nums = new int[]{2,3,1,1,4};
      System.out.println(solution.canJump(nums));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
      /*
        dfs超时，改动归，带备忘录的递归
       */
//    public boolean canJump(int[] nums) {
//        if (nums == null ) return false;
//        return dfs(nums, 0);
//    }
//
//    public boolean dfs(int[] nums, int index){
//        if (index == nums.length - 1) {
//            return true;
//        }
//        if (index >= nums.length) {
//            return false;
//        }
//        if (nums[index] == 0) {
//            return false;
//        }
//
//        int max_jump = nums[index];
////        boolean flag = false;
//        for (int i = max_jump; i >= 1; i--) {
//            if (dfs(nums, index + i)) {
//                return true;
//            }
//        }
//        return false;
//    }

//      /*
//        动归
//       */
//      public boolean canJump(int[] nums) {
//          if (nums == null ) return false;
//          int n = nums.length;
//          boolean[] dp = new boolean[n];
//          dp[n - 1] = true;
//          for (int i = n - 2; i >= 0; i--) {
//              int tmp = nums[i];
//              boolean flag = false;
//              for (int j = 1; j <= tmp && (i+j) < n; j++) {
//                  flag = flag || dp[i+j];
//              }
//              dp[i] = flag;
//          }
//          return dp[0];
//      }

      /*
        最简单的方法
       */
      public boolean canJump(int[] nums) {
          if (nums == null ) return false;
          int maxReach = 0;
          for (int i = 0; i < nums.length; i++) {
              if (i <= maxReach) {
                  maxReach = Math.max(nums[i] + i, maxReach);
                  if (maxReach >= nums.length - 1) {
                      return true;
                  }
              } else {
                  return false;
              }
          }
          return  false;
      }


}
//leetcode submit region end(Prohibit modification and deletion)

}



  