class Solution {
    public boolean hasDuplicate(int[] nums) {
        if (nums.length <= 1) {
            return false;
        } 

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            var current = nums[i];
            var next = nums[i + 1];
            if (current == next) {
                return true;
            }
        }

        return false;
    }
}