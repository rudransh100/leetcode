class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total = 0;
        int max = nums[0];
        int curMax = 0;
        int min = nums[0];
        int curMin = 0;
        for (int num : nums) {
            curMax = Math.max(curMax + num, num);
            max = Math.max(max, curMax);
            curMin = Math.min(curMin + num, num);
            min = Math.min(min, curMin);

            total += num;
        }
        if (max < 0) {
            return max;
        }
        return Math.max(max, total - min);
    }
}