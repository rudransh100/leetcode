class Solution {
    class BIT {
        int[] tree;

        BIT(int n) {
            tree = new int[n + 2];
        }

        void update(int idx, int val) {
            while (idx < tree.length) {
                tree[idx] += val;
                idx += idx & -idx;
            }
        }

        int query(int idx) {
            int sum = 0;
            while (idx > 0) {
                sum += tree[idx];
                idx -= idx & -idx;
            }
            return sum;
        }
    }

    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;

        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + (nums[i] == target ? 1 : -1);
        }

        int[] sorted = prefix.clone();
        Arrays.sort(sorted);

        HashMap<Integer, Integer> map = new HashMap<>();
        int rank = 1;

        for (int x : sorted) {
            if (!map.containsKey(x)) {
                map.put(x, rank++);
            }
        }

        BIT bit = new BIT(rank + 2);

        long ans = 0;

        for (int x : prefix) {
            int idx = map.get(x);

            ans += bit.query(idx - 1);

            bit.update(idx, 1);
        }

        return ans;
    }
}