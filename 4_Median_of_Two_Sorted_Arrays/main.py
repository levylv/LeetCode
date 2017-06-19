#!/usr/bin/env python
# -*- coding: utf-8 -*-
# Lv Wei @ 2016-07-21

class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        N = len(nums1) + len(nums2)
        if N % 2 != 0:
            return self.findkSort(nums1, len(nums1), nums2, len(nums2), (N+1) / 2)
        else:
            return self.findkSort(nums1, len(nums1), nums2, len(nums2), N / 2) / 2.0 + self.findkSort(nums1, len(nums1), nums2, len(nums2), (N / 2) + 1) / 2.0 
    
    def findkSort(self, nums1, m, nums2, n, k):
        if m > n:
            return self.findkSort(nums2, n , nums1, m, k)
        if m == 0:
            return nums2[k-1]
        if k == 1:
            return min(nums1[0], nums2[0])

        dela = min(k / 2, m)
        delb = k - dela
        if nums1[dela - 1] == nums2[delb - 1]:
            return nums1[dela - 1]
        elif nums1[dela - 1] < nums2[delb - 1]:
            return self.findkSort(nums1[dela:], m - dela, nums2, n , k - dela)
        else:
            return self.findkSort(nums1, m, nums2[delb:], n - delb, k - delb)

sol = Solution()
print sol.findMedianSortedArrays([1, 2], [3, 4])




