//给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。 
//
// 换句话说，第一个字符串的排列之一是第二个字符串的子串。 
//
// 示例1: 
//
// 
//输入: s1 = "ab" s2 = "eidbaooo"
//输出: True
//解释: s2 包含 s1 的排列之一 ("ba").
// 
//
// 
//
// 示例2: 
//
// 
//输入: s1= "ab" s2 = "eidboaoo"
//输出: False
// 
//
// 
//
// 注意： 
//
// 
// 输入的字符串只包含小写字母 
// 两个字符串的长度都在 [1, 10,000] 之间 
// 
// Related Topics 双指针 Sliding Window


package com.lvwei.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString{
  public static void main(String[] args) {
       Solution solution = new PermutationInString().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private Map<Character, Integer> need = new HashMap<>();
    private Map<Character, Integer> window = new HashMap<>();
    public boolean checkInclusion(String s1, String s2) {
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        while (right < s2.length()) {
            char c = s2.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);
            while (left <= right && check()) {
                if (right - left + 1 == s1.length()) {
                    return true;
                }
                char cc = s2.charAt(left);
                window.put(cc, window.getOrDefault(cc, 0) - 1);
                left++;
            }
            right++;
        }
        return false;
    }

      public boolean check() {
          for (Map.Entry<Character, Integer> entry : need.entrySet()) {
              if (!window.containsKey(entry.getKey()) || window.get(entry.getKey()) < entry.getValue()) {
                  return false;
              }
          }
          return true;
      }
}
//leetcode submit region end(Prohibit modification and deletion)

}



  