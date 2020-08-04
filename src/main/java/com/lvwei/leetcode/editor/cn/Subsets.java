//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
// 输入: nums = [1,2,3]
//输出:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//] 
// Related Topics 位运算 数组 回溯算法


package com.lvwei.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subsets{
  public static void main(String[] args) {
       Solution solution = new Subsets().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null) return null;
        dfs(nums, new LinkedList<>(), 0);
        return res;
    }

    public void  dfs(int[] nums, LinkedList<Integer> list, int index) {
        if (index == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        dfs(nums, list, index+1);
        list.add(nums[index]);
        dfs(nums, list, index+1);
        list.removeLast();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}



  