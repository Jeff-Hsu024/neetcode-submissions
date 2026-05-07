class Solution {
    public int missingNumber(int[] nums) {
        var len = nums.length;
        var expect = len * (len + 1) / 2;
        var total = 0;
        for (var n : nums) {
            total = total + n;
        }
        return expect - total;
    }
}
