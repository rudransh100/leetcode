class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int prev =-1;
        int next =-1;
        for(int i =0;i<flowerbed.length;i++){
            if(flowerbed[i]==0){
                if(i==0){
                    prev = 0;
                }else{
                    prev = flowerbed[i-1];
                }
                if(i==flowerbed.length-1){
                    next = 0;
                }else{
                    next = flowerbed[i+1];
                }
                if(prev==0&&next==0){
                n--;
                flowerbed[i]=1;
                }
            }
            
            if(n<=0)return true;
        }
        return false;
    }
}