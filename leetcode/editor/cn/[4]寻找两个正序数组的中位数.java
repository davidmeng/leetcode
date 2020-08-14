//给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。 
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
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        int a = totalLength % 2 ;
        int middle = totalLength / 2 ;

    }

    public int findThNumber(int th, int s1, int s2, int e1, int e2, int [] nums1, int [] nums2) {
        if (s1 == e1) {
            return nums2[th-1];
        }

        if (s2 == e2) {
            return nums1[th-1];
        }

        int m1 = (s1 + e1) / 2  ;
        int m2 = (s1 + e1) / 2  ;

        if (nums1[m1] < nums2[m2]) {
            return findThNumber(th-(m1-s1),  m1, s2, e1, e2, nums1, nums2);
        } else {
            return findThNumber(th-(m2-s2),  s1, m2, e1, e2, nums1, nums2);
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
