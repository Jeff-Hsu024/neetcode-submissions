class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return 1;
        }

        Set<Integer> set = new HashSet<>();
        for (var num : nums) {
            set.add(num);
        }

        int max = 1;
        for (var num : set) {
            if (!set.contains(num - 1)) {
                int temp = 1;
                int curnum = num;
                while (set.contains(curnum + 1)) {
                    temp = temp + 1;
                    curnum = curnum + 1;
                }
                if (temp > max) {
                    max = temp;
                }
            }
        }

        return max;
    }
}
