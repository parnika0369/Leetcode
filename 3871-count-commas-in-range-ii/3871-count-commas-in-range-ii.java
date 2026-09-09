class Solution {
    public long countCommas(long n) {

        long ans = 0;
        long div = 1000;

        while (div <= n) {
            ans += n - div + 1;
            div *= 1000;
        }

        return ans;
    }
}