class Solution {

    static int[] findNSE(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i =n-1; i>=0;i--){
            while(!st.isEmpty() && ( arr[st.peek()] >= arr[i])){
                st.pop();
            }
            ans[i] = !st.isEmpty() ? st.peek(): n;
            st.push(i);
        }
        return ans;
    }

    static int[] findPSE(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i =0; i<n;i++){
            while(!st.isEmpty() && ( arr[st.peek()] > arr[i])){
                st.pop();
            }
            ans[i] = !st.isEmpty() ? st.peek() : -1;
            st.push(i);
        }
        return ans;
    }

    public int sumSubarrayMins(int[] arr) {
        int[] NSE = findNSE(arr);
        int[] PSE = findPSE(arr);
        int sum = 0;
        int mod =1000000007;

        for(int i =0 ;i< arr.length ;i++){
            int left = i - PSE[i];
            int right = NSE[i] - i;

            long freq = left * right * 1L;
            int val = (int)((freq * arr[i]) % mod);
            sum = (sum + val) % mod;
        }
        return sum;
    }
}