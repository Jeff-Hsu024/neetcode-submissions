class Solution {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        var first = 1;
        var second = 2;
        for (int i = 3; i <= n; i++) {
            var result = first + second;
            first = second;
            second = result;
        }

        return second;
    }
}
