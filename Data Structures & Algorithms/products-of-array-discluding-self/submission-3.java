class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];

        // index 0 1 2 3
        // nums  1 2 4 6
        // left  1 1 2 8
        int[] left = new int[nums.length];
        left[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        // index 0  1  2 3
        // nums  1  2  4 6
        // right 48 24 6 1
        int[] right = new int[nums.length];
        right[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < res.length; i++) {
            res[i] = left[i] * right[i];
        }

        return res;
    }
}
