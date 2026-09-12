class Solution {
    public int lastStoneWeight(int[] stones) {
        int n = stones.length;
        if(n==1){
            return stones[n-1];
        }
        Arrays.sort(stones);
        while (stones[n-2]!= 0){
            
            int diff = stones[n-1]-stones[n-2];
            if(diff != 0){
                stones[n-2] = 0;
                stones[n-1] = diff;
            }
            else{
                stones[n-2] = 0;
                stones[n-1] = 0;
            }
            Arrays.sort(stones);
        }
        return stones[n-1];
    }
}
