//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法


package com.lvwei.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations{
  public static void main(String[] args) {
       Solution solution = new Permutations().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        dfs(new LinkedList<>(), nums);
        return res;
    }

    public void dfs(LinkedList<Integer> permute, int[] nums) {
        if (permute.size() == nums.length) {
            res.add(new LinkedList<>(permute));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (permute.contains(nums[i])) {
                continue;
            }
            permute.add(nums[i]);
            dfs(permute, nums);
            permute.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}



  