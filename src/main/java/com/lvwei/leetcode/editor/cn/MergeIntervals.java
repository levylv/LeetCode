//给出一个区间的集合，请合并所有重叠的区间。 
//
// 示例 1: 
//
// 输入: [[1,3],[2,6],[8,10],[15,18]]
//输出: [[1,6],[8,10],[15,18]]
//解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2: 
//
// 输入: [[1,4],[4,5]]
//输出: [[1,5]]
//解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。 
// Related Topics 排序 数组


package com.lvwei.leetcode.editor.cn;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals{
  public static void main(String[] args) {
       Solution solution = new MergeIntervals().new Solution();
       int[][] interval = new int[][]{
                new int[]{1,3},
                new int[]{2,6},
                new int[]{8,10},
                new int[]{15,18}
       };
      System.out.println(solution.merge(interval));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null) return null;
        if (intervals.length == 0) return intervals;
        if (intervals[0] == null) return intervals;
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        List<int[]> tmp = new ArrayList<>();
        int i = 0;
        int j = 1;
        while (j < intervals.length) {
            if (intervals[i][1] >= intervals[j][0]) {
                intervals[i][1] = Math.max(intervals[i][1], intervals[j][1]);
                j++;
            } else {
                tmp.add(intervals[i]);
                i = j;
                j = i+1;
            }
        }
        tmp.add(intervals[i]);
        int[][] res = new int[tmp.size()][2];
        for (i = 0; i < tmp.size(); i++) {
            res[i][0] = tmp.get(i)[0];
            res[i][1] = tmp.get(i)[1];
        }
        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}



  