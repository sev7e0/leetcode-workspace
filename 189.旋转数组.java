/*
 * @lc app=leetcode.cn id=189 lang=java
 *
 * [189] 旋转数组
 */

// @lc code=start
class Solution {
    public void rotate(int[] nums, int k) {
        int len  = nums.length;
        k = k % len;
        int count = 0;         // 记录交换位置的次数，n个同学一共需要换n次
         for(int start = 0; count < len; start++) {
             int cur = start;       // 从0位置开始换位子
             int pre = nums[cur];   // 记录当前的位置
             do{
                 int next = (cur + k) % len; // 计算下一个位置
                 int temp = nums[next];    // 将下一个位置放到temp中
                 nums[next] = pre; // pre进行占座
                 pre = temp;    //更新当前位置变量 pre为temp中的值
                 cur = next;    //更新cur变量为next的位置索引
                 count++;
             }while(start != cur);// 如果cur等于start那么说明一次循环替换完成，跳出循环进行下一次
         }   
     } 
 
}
// @lc code=end

