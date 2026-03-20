class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int[] res = new int [temperatures.length];
        for(int i = 0; i<temperatures.length;i++){
            while(!st.isEmpty()&& temperatures[i]>temperatures[st.peek()]){
                int prev = st.peek();
                int diff = i-prev;
                res[prev] = diff;
                st.pop();

            }
            st.push(i);
        }
        return res;
    }
}