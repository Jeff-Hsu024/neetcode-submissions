class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];


        // 0 1 2 3
        // 1 2 4 6
        // 1 1 2 8

        int[] left = new int[len];
        left[0] = 1;
        for (int i = 1; i < len; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        // 0  1  2 3
        // 1  2  4 6
        // 48 24 6 1
        int[] right = new int[len];
        right[len - 1] = 1;
        for (int i = len - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < len; i++) {
            res[i] = left[i] * right[i];
        }

        return res;
    }
}
