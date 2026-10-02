class Solution {
    static void paranthesis(String s, int n, int open, int closed, List<String> result) {
        if (s.length() == 2 * n) {
            result.add(s);
            return;
        }
        if (open < n) {
            paranthesis(s + "(", n, open + 1, closed, result);
        }
        if (closed < open) {
            paranthesis(s + ")", n, open, closed + 1, result);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        paranthesis("", n, 0, 0, result);
        return result;
    }
}