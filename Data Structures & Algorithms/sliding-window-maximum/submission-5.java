class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 7 - 3 + 1
        // 7 5
        // 8 6
        int[] res = new int[nums.length - k + 1];

        for (int i = 0; i < res.length; i++) {
            int max = nums[i];
            for (int j = i; j < k + i; j++) {
                max = Math.max(max, nums[j]);
                res[i] = max;
            }
        }

        return res;
    }
}
