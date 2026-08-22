class Solution {
    public boolean checkDivisibility(int n) {
        int product =1;
        int sum = 0;
        int num = n;
        while(num>0){
            int digit = num%10;
            sum+=digit;
            product*=digit;
            num/=10;
        }
        if(n %(sum+product)==0){
            return true;
        }
        return false;
    }
}