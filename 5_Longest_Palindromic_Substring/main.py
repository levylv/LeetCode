#!/usr/bin/env python
# -*- coding: utf-8 -*-
# Lv Wei @ 2016-11-10

class Solution(object):
    def findLPS(self, s):
        n = len(s)
        f = [[False for j in range(n)] for i in range(n)]
        maxLen = 1
        start = 0
        for i in range(n):
            f[i][i] = True
            for j in range(i):
                f[j][i] = (s[j] == s[i]) & ((i - j == 1) | (f[j+1][i-1]))
                if f[j][i] & (i - j + 1 > maxLen):
                    maxLen = i - j + 1
                    start = j
        return s[start:(start + maxLen)]

A = Solution();
print A.findLPS('babad')





