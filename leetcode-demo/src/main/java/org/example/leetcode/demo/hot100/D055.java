package org.example.leetcode.demo.hot100;

/**
 * @description:
 * @author: lvxuhong
 * @date: 2021/11/21
 */
public class D055 {
    public static void main(String[] args) {
        new D055().canJump(new int[]{0});
    }

    /**
     * 需要找到最大可以到达的点，如果i是可以到达的，那么i前面的所有的点都是可以到达的
     * 最远到达的距离为 i + nums[i]
     * 以[2,3,1,1,4]为例子
     * i = 0时，最远到达的距离为 0 + 2 = 2
     * i = 1时，最远到达的距离时 1 + 3 = 4，此时4 = nums.length - 1正好可以到达。
     * <p>
     * 注意：如果在遍历的过程中，发现i > m,此时位置i已经时不可达的了，所以，直接返回false
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int m = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= m) {
                m = Math.max(m, nums[i] + i);
                if (m >= nums.length - 1) {
                    return true;
                }
            } else {
                break;
            }
        }
        return false;
    }
}
