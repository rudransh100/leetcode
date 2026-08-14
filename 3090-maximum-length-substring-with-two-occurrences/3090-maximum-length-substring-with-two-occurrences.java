class Solution {
    public int maximumLengthSubstring(String s) {
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            Map<Character, Integer> mpp = new HashMap<>();
            for (int j = i; j < s.length(); j++) {
                char ch = s.charAt(j);
                if (mpp.getOrDefault(ch, 0) == 2) {
                    break;
                }
                mpp.put(ch, mpp.getOrDefault(ch, 0) + 1);
                max = Math.max(max, j - i + 1);
            }
        }

        return max;
    }
}