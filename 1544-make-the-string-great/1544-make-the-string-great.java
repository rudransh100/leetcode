class Solution {
    public String makeGood(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (sb.length() > 0) {
                char last = sb.charAt(sb.length() - 1);
                if (curr != last && Character.toLowerCase(curr) == Character.toLowerCase(last)) {
                    sb.deleteCharAt(sb.length() - 1);
                    continue;
                }
            }
            sb.append(curr);
        }
        return sb.toString();
    }
}