//给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。 
//
// 示例： 
//
// 输入: S = "ADOBECODEBANC", T = "ABC"
//输出: "BANC" 
//
// 说明： 
//
// 
// 如果 S 中不存这样的子串，则返回空字符串 ""。 
// 如果 S 中存在这样的子串，我们保证它是唯一的答案。 
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window


package com.lvwei.leetcode.editor.cn;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class MinimumWindowSubstring{
  public static void main(String[] args) {
//       Solution solution = new MinimumWindowSubstring().new Solution();
      int a = 3, b = 4;
      double c = (a + b) / 2.0;
      System.out.println(c);
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private Map<Character, Integer> need = new HashMap<>();
    private Map<Character, Integer> window = new HashMap<>();
    public String minWindow(String s, String t) {
        for (int i = 0; i < t.length(); i++) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }


//        PriorityQueue<String> q = new PriorityQueue<>((o1, o2) -> o1.length() -o2.length());
//
//        List<Integer> res = new LinkedList<>();
//        List<List<Integer>> x = new LinkedList<>();
//        Deque<Integer> deq = new ArrayDeque<>();
//
//        int[] a = new int[2];
        int left = 0, right = 0;
        int resL = -1, resR = -1;
        int min = Integer.MAX_VALUE;
        while (right < s.length()) {
            window.put(s.charAt(right), window.getOrDefault(s.charAt(right), 0) + 1);
            while (left <= right && check()) {
                if (right - left + 1 < min) {
                    resL = left;
                    resR = right;
                    min = right - left + 1;
                }
                window.put(s.charAt(left), window.getOrDefault(s.charAt(left), 0) - 1);
                left++;
            }
            right++;

        }
        return resL == -1 ? "" : s.substring(resL, resR+1);
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



  