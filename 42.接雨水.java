import java.util.Stack;

/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

/**
 * 第一种解法：根据每一列进行求值，遍历当前列，之后找到左右两边最高的墙，从最高的墙求出小的那个，判断 小的那个是否大于当前的墙，大于则用
 * min墙-当前墙=能保存的水量
 */
class Solution1 {
    public int trap(int[] height) {
        int len = height.length;
        int ans = 0;
        for (int i = 1; i < len - 1; i++) {

            int maxLeft = 0;
            // 从当前墙的左侧第一位出发，找到最高的墙
            for (int j = i - 1; j >= 0; j--) {
                if (height[j] > maxLeft) {
                    maxLeft = height[j];
                }
            }

            int maxRight = 0;

            for (int j = i + 1; j < len; j++) {
                if (height[j] > maxRight) {
                    maxRight = height[j];
                }
            }

            int min = Math.min(maxLeft, maxRight);
            if (min > height[i]) {
                ans += min - height[i];
            }

        }
        return ans;

    }
}

/**
 * 解法二：动态规划，解法一中对每一列求存水量时，都需要遍历一次整个数组，来寻找左右最高的墙，
 * 优化的点就是如此，先对整个数组遍历，找到每一列对应的最高左右两边，然后记录在左右两个数组
 * 中，最后使用解法一的思路，从左右最高数组中找到对应的值，计算即可。
 * 
 * 空间复杂度：O(n)
 * 时间复杂度：O(n)
 */
class Solution2 {
    public int trap(int[] height) {
        int length = height.length;
        int result = 0;
        int[] maxLeft = new int[length];
        int[] maxRight = new int[length];

        //求某一列的左边最高
        for (int i = 1; i < length-1; i++) {
            maxLeft[i] = Math.max(height[i-1], maxLeft[i-1]);
        }
        //求某一列的右边最高
        for (int i = length-2; i >= 0; i--) {
            maxRight[i] = Math.max(height[i+1], maxRight[i+1]);
        }

        for (int i = 1; i < length-1; i++) {
            int min = Math.min(maxLeft[i], maxRight[i]);
            if (min > height[i]){
                result += min -height[i];
            }
        }
        return result;
    }
}
// @lc code=start
class Solution {
    public int trap(int[] height) {
        int left = 1;
        int right = height.length-2;

        int result=0,leftMax = 0;
        int rightMax = height.length-1;

        /**
         * 定理一：在某个位置i处，它能存的水，取决于它左右两边的最大值中较小的一个。
         * 
         * 定理二：当我们从左往右处理到left下标时，左边的最大值left_max对它而言是可信的，
         * 但right_max对它而言是不可信的。（见下图，由于中间状况未知，对于left下标而言，
         * right_max未必就是它右边最大的值）
         * 
         * 定理三：当我们从右往左处理到right下标时，右边的最大值right_max对它而言是可信的，
         * 但left_max对它而言是不可信的。
                                                right_max
            left_max                              __
               __                                |  |
              |  |__   __??????????????????????  |  |
            __|     |__|                       __|  |__
                    left                      right
         */
        /**
         * 对于位置left而言，它左边最大值一定是left_max，
         * 右边最大值“大于等于”right_max，这时候，如果left_max<right_max成立，
         * 那么它就知道自己能存多少水了。无论右边将来会不会出现更大的right_max，
         * 都不影响这个结果。 所以当left_max<right_max时，我们就希望去处理left下标，
         * 反之，我们希望去处理right下标。
         */
        while (left <= right) {
            //如果右边大于左边，那么装水量由由较低的左边决定
            if (height[leftMax]< height[rightMax]) {
                if (height[leftMax] > height[left]) {
                    result += height[leftMax] - height[left];
                }else{
                    leftMax = left;
                }
                left++;

            //否则装水量由右边决定
            }else{
                //如果右边rightMax上的值小于右边right上的值
                //说明当前右边rightMax上的值不是最大的，将left 赋值给rightMax
                if (height[right]>height[rightMax]) {
                    rightMax = right;
                }else{
                    result += height[rightMax] - height[right];
                }
                right--;
            }
        }

        return result;

    }
}
/**
Your runtime beats 99.99 % of java submissions
Your memory usage beats 12.86 % of java submissions (39.5 MB)
 */
// @lc code=end

class Solution4 {
    public int trap(int[] height) {
        if (height == null) {
            return 0;
        }
        int result = 0;
        Stack<Integer> stack = new Stack<>();

        //从左到右遍历一遍
        for (int i = 0; i < height.length; i++) {
            //如果栈不为空，且i当前位置上的值大于栈顶元素，则进行出栈比较
            while (!stack.isEmpty() && height[stack.peek()]< height[i]) {
                //当前栈顶元素
                int current = stack.pop();
                //如果出栈后的栈顶元素与current上的相等，那么继续出栈
                while (!stack.isEmpty() && height[stack.peek()] == height[current]) {
                    stack.pop();
                }
                //如果剩下的栈不为空，那么取出栈顶元素
                if (!stack.isEmpty()) {
                    int stackTop = stack.peek();
                    // stackTop此时指向的是此次接住的雨水的左边界的位置。右边界是当前的柱体，即i。
                    // Math.min(height[stackTop], height[i]) 是左右柱子高度的min，减去height[curIdx]就是雨水的高度。
                    // i - stackTop - 1 是雨水的宽度。

                    //先从左右两边的高墙选出较矮的，再减去current位置的，就是本次计算的高度
                    int high = Math.min(height[stackTop], height[i]) - height[current];

                    //当前i的位置
                    int width = i - 1 -stackTop;
                    result += high * width;
                }
            
            }
            stack.add(i);
        }

        return result;
    }
}
/**
Your runtime beats 31.61 % of java submissions
Your memory usage beats 12.86 % of java submissions (39.6 MB)
 */
