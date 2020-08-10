package org.example.gateway.demo;

import java.util.Map;
import java.util.HashMap;

/**
 * @description:
 * @author:lvxuhong
 * @date:2020/8/10
 */
public class Main {

    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        a.setB(b);
        b.setA(a);
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (m.get(target - nums[i]) != null) {
                return new int[]{m.get(target - nums[i]), i};
            }
            m.put(nums[i], i);
        }
        throw new RuntimeException("没有结果");
    }
}


