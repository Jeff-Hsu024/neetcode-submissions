class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int maxConsecutive = 1;
        int currentConsecutive = 1;

        Arrays.sort(nums);
        int preNum = nums[0];
        int length = nums.length;

        for (int i = 1; i < length; i++) {
            var num = nums[i];
            if (preNum == num) {
                continue;
            }

            if (preNum + 1 == num) {
                currentConsecutive = currentConsecutive + 1;
                if (currentConsecutive > maxConsecutive) {
                    maxConsecutive = currentConsecutive;
                }
            } else {
                currentConsecutive = 1;
                // 5
                // 1 2 3 5 6
                // 0 1 2 3 4
                // 3
                int remainNums = length - i - 1;
                if (maxConsecutive >= remainNums) {
                    return maxConsecutive;
                }
            }
            preNum = num;
        }

        return maxConsecutive;
    }
}
