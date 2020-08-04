//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Mar
//cos 贡献此图。 
//
// 示例: 
//
// 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//输出: 6 
// Related Topics 栈 数组 双指针


package com.lvwei.leetcode.editor.cn;
public class TrappingRainWater{
  public static void main(String[] args) {
       Solution solution = new TrappingRainWater().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /*
        dp方法
     */
//    public int trap(int[] height) {
//        if (height == null || height.length <= 1) return 0;
//        int n = height.length;
//        int[] left_max = new int[n];
//        int[] right_max = new int[n];
//        left_max[0] = height[0];
//        right_max[n-1] = height[n-1];
//        for (int i = 1; i < n; i++){
//            left_max[i] = Math.max(left_max[i-1], height[i]);
//        }
//        for (int j = n - 2; j >= 0; j--) {
//            right_max[j] = Math.max(right_max[j+1], height[j]);
//        }
//        int res = 0;
//        for (int i = 0; i < n; i++) {
//            res += Math.min(right_max[i], left_max[i]) - height[i];
//        }
//        return  res;
//    }

    /*
        双指针
     */
      public int trap(int[] height) {
          if (height == null || height.length <= 1) return 0;
          int left = 0;
          int right = height.length - 1;
          int left_max = 0;
          int right_max = 0;
          int res = 0;
          while (left <= right) {
              if (height[left] < height[right]) {
                  if (height[left] >= left_max) {
                      left_max = height[left];
                  } else {
                      res += left_max - height[left];
                  }
                  left++;
              } else {
                  if (height[right] >= right_max) {
                      right_max = height[right];
                  } else {
                      res += right_max - height[right];
                  }
                  right--;
              }
          }
          return res;

      }

}
//leetcode submit region end(Prohibit modification and deletion)

}



  