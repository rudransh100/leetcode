class Solution {
    public int maxSubarrayLength(int[] nums, int k) {

        Map<Integer, Integer> mpp = new HashMap<>();
        int max = 0;
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            mpp.put(nums[j], mpp.getOrDefault(nums[j], 0) + 1);
            while (mpp.get(nums[j]) > k) {
                mpp.put(nums[i], mpp.get(nums[i]) - 1);
                i++;
            }
            max = Math.max(max, j - i + 1);
        }

        return max;
    }
}