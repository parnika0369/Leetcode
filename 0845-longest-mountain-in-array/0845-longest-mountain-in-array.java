class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        int[] up = new int[n];
        int[] down = new int[n];

        for(int i=0; i<n; i++){
            up[i] = 1;
            if(i>0 && arr[i]>arr[i-1]){
                up[i] = up[i-1] + 1;
            }
        }
        for(int i=n-1; i>=0; i--){
            down[i] = 1;
            if(i<n-1 && arr[i]>arr[i+1]){
                down[i] = down[i+1] + 1;
            }
        }
        int ans = 0;

        for(int i=0; i<n; i++){
            if(up[i]>1 && down[i]>1){
                ans = Math.max(ans, up[i]+down[i]-1);
            }
        }
        return ans;
    }
}