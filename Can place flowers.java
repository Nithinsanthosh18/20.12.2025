class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) { 

        if(n==0){
            return true;
        }

        int copy = n;
        for (int i = 0; i < flowerbed.length; i++) {
         boolean leftSide=(i==0 || flowerbed[i-1]==0);
         boolean rightSide=(i==flowerbed.length-1 || flowerbed[i+1]==0);
         if(flowerbed[i]==0){
            if(leftSide && rightSide){
                flowerbed[i]=1;
                copy--;
            }
         }
        }
      
        if(copy==0){
            return true;
        }
    
            return true;
        }

       return false;
    }
}
