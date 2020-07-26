import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        m = m - 1;
        n = n - 1;
        for (int i = nums1.length - 1; i >= 0; i--) {
            if (m < 0) {
                System.arraycopy(nums2, 0, nums1, 0, n);
                break;
            }
            if (n < 0) {
                break;
            }
            nums1[i] = nums1[m] >= nums2[n] ? nums1[m--] : nums2[n--];

        }
        System.arraycopy(nums2, 0, nums1, 0, n + 1);
    }
}
// @lc code=end
