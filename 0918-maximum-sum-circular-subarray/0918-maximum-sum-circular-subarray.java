class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total = 0;
        int max = nums[0];
        int curMax = 0;
        int min = nums[0];
        int curMin = 0;
        for (int i=0;i<nums.length;i++) {
            curMax = Math.max(curMax + nums[i], nums[i]);
            max = Math.max(max, curMax);
            curMin = Math.min(curMin + nums[i], nums[i]);
            min = Math.min(min, curMin);

            total += nums[i];
        }
        if (max < 0) {
            return max;
        }
        return Math.max(max, total - min);
    }
}