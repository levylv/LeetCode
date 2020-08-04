//给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。 
//
// 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。 
//
// 说明： 
//
// 
// 字母异位词指字母相同，但排列不同的字符串。 
// 不考虑答案输出的顺序。 
// 
//
// 示例 1: 
//
// 
//输入:
//s: "cbaebabacd" p: "abc"
//
//输出:
//[0, 6]
//
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
// 
//
// 示例 2: 
//
// 
//输入:
//s: "abab" p: "ab"
//
//输出:
//[0, 1, 2]
//
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
// 
// Related Topics 哈希表


package com.lvwei.leetcode.editor.cn;

import java.util.*;

public class FindAllAnagramsInAString{
  public static void main(String[] args) {
       Solution solution = new FindAllAnagramsInAString().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private Map<Character, Integer> need = new HashMap<>();
    private Map<Character, Integer> window = new HashMap<>();
    public List<Integer> findAnagrams(String s, String p) {
        for (int i = 0; i < p.length(); i++) {
            need.put(p.charAt(i), need.getOrDefault(p.charAt(i), 0) + 1);
        }

        int left = 0, right = 0;
        List<Integer> res = new ArrayList<>();
        while (right < s.length()) {
            char c1 = s.charAt(right);
            window.put(c1, window.getOrDefault(c1, 0) + 1);
            if (right - left + 1 == p.length()) {
                if (check()) {
                    res.add(left);
                }
                char c2 = s.charAt(left);
                window.put(c2, window.getOrDefault(c2, 0) - 1);
                left++;
            }
            right++;
        }
        return res;
    }

      public boolean check() {
          for (Map.Entry<Character, Integer> entry : need.entrySet()) {
              if (!window.containsKey(entry.getKey()) || !window.get(entry.getKey()).equals(entry.getValue())) {
                  return false;
              }
          }
          return true;
      }
}
//leetcode submit region end(Prohibit modification and deletion)

}



  