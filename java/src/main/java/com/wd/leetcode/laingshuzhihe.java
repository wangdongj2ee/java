package com.wd.leetcode;

//        给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
//
//        你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
//        示例:
//        给定 nums = [2, 7, 11, 15], target = 9
//        因为 nums[0] + nums[1] = 2 + 7 = 9
//        所以返回 [0, 1]
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/two-sum
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


import java.util.HashMap;

public class laingshuzhihe {

    public static void main(String[] arg0) {
        int[] nums = {0, 2, 5, 10, 2};
        int target = 4;
        try {
            int[] res = new laingshuzhihe().twoSum(nums, target);
            System.out.println(res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int[] twoSum(int[] nums, int target){
        try {
            if (nums == null || nums.length < 1) {
                throw new Exception("参数异常");
            }
            HashMap<Integer, Integer> map = new HashMap<>(nums.length/3*4+1);
            for (int i = 0; i < nums.length; i++) {
                int j = target - nums[i];
//                Integer x = map.get(j);
                if (map.containsKey(j)) {
                    return new int[]{map.get(j), i};
                } else {
                    map.put(nums[i], i);
                }
            }
            throw new Exception("没有结果");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
