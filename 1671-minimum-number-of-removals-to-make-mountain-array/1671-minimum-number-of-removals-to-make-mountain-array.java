class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        
        //LIS from the left
        int[] lis = new int[n];
        Arrays.fill(lis, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
        }

        //LDS from the right
        int[] lds = new int[n];
        Arrays.fill(lds, 1);
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (nums[j] < nums[i]) {
                    lds[i] = Math.max(lds[i], lds[j] + 1);
                }
            }
        }

        // Find the longest mountain
        int maxMountain = 0;
        for (int i = 1; i < n - 1; i++) {
            if (lis[i] > 1 && lds[i] > 1) { // It needs a peak in the middle
                int mountainLength = lis[i] + lds[i] - 1; // i counted twice
                maxMountain = Math.max(maxMountain, mountainLength);
            }
        }

        // Minimum removals = total length minus longest mountain length
        return n - maxMountain;
    }
}