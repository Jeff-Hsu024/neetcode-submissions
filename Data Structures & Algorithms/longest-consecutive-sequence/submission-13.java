class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return 1;
        }

        Arrays.sort(nums);

        int max = 1;
        int temp = 1;
        int pre = nums[0];

        for (int i = 1; i < nums.length; i++) {
            var cur = nums[i];
            if (cur == pre) {
                continue;
            }
            if (cur - 1 == pre) {
                temp = temp + 1;
            } else {
                temp = 1;
            }

            if (temp > max) {
                max = temp;
            }
            pre = cur;
        }

        return max;
    }
}
