class Solution {
    static final int MOD = 1000000007;

    public int xorAfterQueries(int[] nums, int[][] queries) {

        for (int[] q : queries) {
            int l = q[0], r = q[1], step = q[2], mul = q[3];

            for (int i = l; i <= r; i += step) {
                nums[i] = (int)((long)nums[i] * mul % MOD);
            }
        }

        int res = 0;
        for (int num : nums) {
            res ^= num;
        }

        return res;
    }
}