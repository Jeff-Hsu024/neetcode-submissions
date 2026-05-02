class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (var num : nums) {
            set.add(num);
        }

        int res = 0;

        for (var num : set) {
            // still has pre num
            if (set.contains(num - 1)) {
                continue;
            }

            int count = 0;
            int cur = num;
            while (set.contains(cur)) {
                count = count + 1;
                cur = cur + 1;
            }

            res = Math.max(res, count);
        }

        return res;
    }
}
