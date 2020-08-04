//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串


package com.lvwei.leetcode.editor.cn;

import java.lang.reflect.Array;
import java.util.*;

public class GroupAnagrams{
  public static void main(String[] args) {
       Solution solution = new GroupAnagrams().new Solution();
       String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
      System.out.println(solution.groupAnagrams(strs));

  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        String[] sortStr = new String[strs.length];
        for (int i = 0; i < strs.length; i++) {
            sortStr[i] = stringSort(strs[i]);
        }
        List<List<String>> res = new ArrayList<>();
        HashMap<String, List<String>> newMap = new HashMap<>();
        for (int i = 0 ; i < strs.length; i++) {
            if (newMap.containsKey(sortStr[i])) {
                newMap.get(sortStr[i]).add(strs[i]);
            } else {
                List<String> tmp = new ArrayList<>();
                tmp.add(strs[i]);
                newMap.put(sortStr[i], tmp);
            }
        }
        for (Map.Entry<String, List<String> > entry : newMap.entrySet()) {
            res.add(entry.getValue());
        }
        return  res;
    }

    public String stringSort(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}



  