package leetcode.temp.LeetCode.dp;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class _303_RangeSumQuery_Immutable {

    @Test
    public void test1() {
        NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        assertNumArray(numArray, 0, 2, 1);
        assertNumArray(numArray, 2, 5, -1);
        assertNumArray(numArray, 0, 5, -3);
    }

    private void assertNumArray(NumArray numArray, int i, int j, int expected) {
        Assert.assertEquals(expected, numArray.sumRange(i, j));
    }

//    class NumArray {
//        private int[] nums;
//
//        public NumArray(int[] nums) {
//            this.nums = nums;
//        }
//
//        public int sumRange(int i, int j) {
//            int sum = 0;
//            for (; i <= j; i++) {
//                sum += nums[i];
//            }
//            return sum;
//        }
//    }

    class NumArray {
        private int[] nums;

        public NumArray(int[] nums) {
            for (int i = 1; i < nums.length; i++) {
                nums[i] += nums[i - 1];
            }
            this.nums = nums;
        }

        public int sumRange(int i, int j) {
            return (i == 0) ? nums[j] : nums[j] - nums[i - 1];
        }
    }

}