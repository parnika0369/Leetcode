class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length;
        int ans = 1;

        for (int left = 0; left < n; left++) {
            long product = 1;
            long lcm = 1;
            int g = 0;

            for (int right = left; right < n; right++) {
                int x = nums[right];

                product *= x;
                g = gcd(g, x);
                lcm = lcm(lcm, x);

                if (product == lcm * g) {
                    ans = Math.max(ans, right - left + 1);
                }
            }
        }

        return ans;
    }

    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public long lcm(long a, long b) {
        return (a / gcd((int)a, (int)b)) * b;
    }
}