class Solution {
    boolean isValid[];
    int count = 0;
    int n = 0;
    public int countArrangement(int n) {
        this.n = n;
        isValid = new boolean[n+1];
        if(n==1)return 1;
        if(n==2)return 2;
        helper(n, isValid);
        return count;
    }
    public void helper(int start, boolean[] isValid){
        if(start<1){
            count++;
            return;
        }

        for(int i=n;i>=1;i--){
            if(isValid[i])continue;
            if(start%i==0 || i%start==0){
                isValid[i]=true;
                helper(start-1, isValid);
                isValid[i]=false;
            }
        }
    }
}
