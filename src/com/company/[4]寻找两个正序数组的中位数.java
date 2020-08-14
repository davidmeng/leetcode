package com.company;//给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
//
// 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
//
// 你可以假设 nums1 和 nums2 不会同时为空。
//
//
//
// 示例 1:
//
// nums1 = [1, 3]
//nums2 = [2]
//
//则中位数是 2.0
//
//
// 示例 2:
//
// nums1 = [1, 2]
//nums2 = [3, 4]
//
//则中位数是 (2 + 3)/2 = 2.5
//
// Related Topics 数组 二分查找 分治算法


//leetcode submit region begin(Prohibit modification and deletion)
class Solution1 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        int a = totalLength % 2;
        int middle = (totalLength - 1) / 2;

        Result r = new Result();


        if (totalLength % 2 == 0) {
            int find = findThNumber(middle, r, nums1, nums2);
            int find1 = findThNumber(0, r, nums1, nums2);
            return ((double) find + (double) find1) / 2d;
        } else {
            int find = findThNumber(middle, r, nums1, nums2);
            return (double) find;
        }
    }

    public int findThNumber(int th, Result r, int[] nums1, int[] nums2) {

        int s1 = r.start1;
        int s2 = r.start2;

        if (s1 == nums1.length) {
            r.start2 += th;
            return nums2[r.start2++];
        }

        if (s2 == nums2.length) {
            r.start1 += th;
            return nums1[r.start1++];
        }

        if (th == 0) {
            if (nums1[s1] < nums2[s2]) {

                return nums1[r.start1++];
            } else {

                return nums2[r.start2++];
            }
        }

        int m1 = (s1 + nums1.length - 1) / 2;
        int m2 = (s2 + nums2.length - 1) / 2;

        if (nums1[m1] < nums2[m2]) {
            r.start1 = m1;
            r.start1++;
            return findThNumber(th - (m1 - s1), r, nums1, nums2);
        } else {
            r.start2 = m2;
            r.start2++;
            return findThNumber(th - (m2 - s2), r, nums1, nums2);
        }
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        System.out.println(s.findMedianSortedArrays(new int[]{ 1, 2 }, new int[]{3, 4 }));
    }

    private static class Result {

        int start1 = 0;
        int start2 = 0;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
