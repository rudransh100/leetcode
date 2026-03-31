import java.util.*;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+") || tokens[i].equals("-") ||
                    tokens[i].equals("*") || tokens[i].equals("/")) {
                int op2 = st.pop();
                int op1 = st.pop();
                int res = 0;
                String op = tokens[i];

                if (op.equals("+")) {
                    res = op1 + op2;
                } else if (op.equals("-")) {
                    res = op1 - op2;
                } else if (op.equals("*")) {
                    res = op1 * op2;
                } else if (op.equals("/")) {
                    res = op1 / op2;
                }

                st.push(res);
            } else {
                st.push(Integer.parseInt(tokens[i]));
            }
        }
        return st.pop();
    }
}