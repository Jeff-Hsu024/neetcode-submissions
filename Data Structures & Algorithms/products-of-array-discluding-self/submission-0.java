class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        left[0] = 1;
        
        int[] right = new int[nums.length];
        right[right.length - 1] = 1;

        int[] result = new int[nums.length];

        // 1 2 3 4
        // 1 1 2 6
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        //  1  2 3 4
        // 24 12 4 1
        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < result.length; i++) {
            result[i] = left[i] * right[i];
        }

        return result;
    }
}  
