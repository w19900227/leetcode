package leetcode.temp.LeetCode.dp;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class _307_RangeSumQuery_Mutable {

    @Test
    public void test1() {
        NumArray numArray = new NumArray(new int[]{1, 3, 5});
        assertNumArray(numArray, 0, 2, 9);
        numArray.update(1, 2);
        assertNumArray(numArray, 0, 2, 8);
    }

    private void assertNumArray(NumArray numArray, int i, int j, int expected) {
        Assert.assertEquals(expected, numArray.sumRange(i, j));
    }

    class NumArray {
        private int[] nums;

        public NumArray(int[] nums) {
            helper(nums, 1);
        }

        public void update(int index, int val) {
            nums[index] = val;
            helper(this.nums, index);
        }

        public int sumRange(int left, int right) {
            return (left == 0) ? nums[right] : nums[right] - nums[left - 1];
        }

        private void helper(int[] nums, int index) {
            for (int i = index; i < nums.length; i++) {
                nums[i] += nums[i - 1];
            }
            this.nums = nums;
        }
    }

}