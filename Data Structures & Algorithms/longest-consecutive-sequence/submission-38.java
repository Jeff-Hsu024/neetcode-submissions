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
            // first num
            if (!set.contains(num - 1)) {
                int cur = num;
                int count = 0;
                while (set.contains(cur)) {
                    cur = cur + 1;
                    count = count + 1;
                }

                if (count > max) {
                    max = count;
                }
            }
        }
        return max;
    }
}
