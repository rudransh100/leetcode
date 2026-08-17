class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int x : asteroids){
            boolean temp = true;
            while(!st.isEmpty()&& (st.peek()>0&&x<0)){
                if( Math.abs(st.peek())<Math.abs(x)){
                    st.pop();
                    temp = true;
                }else if( Math.abs(st.peek())==Math.abs(x)){
                    st.pop();
                    temp = false;
                    break;
                }
                else{
                    temp = false;
                    break;
                }
            }
            if(temp)st.push(x);
        }
        int[] res = new int[st.size()];
        for(int i = st.size()-1;i>=0;i--){
            res[i] = st.pop();
        }
        return res;
    }
}