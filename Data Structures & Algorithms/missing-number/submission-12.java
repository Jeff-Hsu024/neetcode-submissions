class Solution {
    public int missingNumber(int[] nums) {
        var len = nums.length;
        var expectSum = len * (len + 1) / 2;
        for (var num : nums) {
            expectSum = expectSum - num;
        }

        return expectSum;
    }
}
