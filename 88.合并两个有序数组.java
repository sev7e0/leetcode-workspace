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
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              

        // int[] newNums = Arrays.copyOf(nums1, m);
        // int mIndex = 0;
        // int nIndex = 0;
        // for (int i = 0; i < nums1.length; i++) {
        //     // 当nums1全部排序完成后，将nums2剩余都放到数组中
        //     if (mIndex == m) {
        //         System.arraycopy(nums2, nIndex, nums1, i, n - nIndex);
        //         break;
        //     }
        //     if (nIndex == n) {
        //         System.arraycopy(newNums, mIndex, nums1, i, m - mIndex);
        //         break;
        //     }
        //     if (newNums[mIndex] >= nums2[nIndex]) {
        //         nums1[i] = nums2[nIndex];
        //         nIndex++;
        //     } else {
        //         nums1[i] = newNums[mIndex];
        //         mIndex++;
        //     }
        // }
    }
}
// @lc code=end
