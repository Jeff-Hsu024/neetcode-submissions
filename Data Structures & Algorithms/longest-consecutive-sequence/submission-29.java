class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length ==0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }

        Set<Integer> set = new HashSet<>();
        for (var num: nums) {
            set.add(num);
        }

        int max = 1;

        for (var num: set) {
            // no previous number, so this will begin.
            if (!set.contains(num -1)) {
                int temp = 1;
                int cur = num;
                while (set.contains(cur + 1)) {
                    temp = temp + 1;
                    cur = cur + 1;
                }
                if (temp > max) {
                    max = temp;
                }
            }
        }

        return max;

    }
}
