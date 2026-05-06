class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for (var n : nums) {
            set.add(n);
        }
        for (var n : set) {
            var pre = n - 1;
            if (set.contains(pre)) {
                continue;
            }

            int count = 0;
            int cur = n;
            while (set.contains(cur)) {
                count++;
                cur++;
            }
            res = Math.max(res, count);
        }

        return res;
    }
}
