class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (var n : nums) {
            set.add(n);
        }
        int res = 0;
        for (var n : set) {
            var pre = n - 1;
            if (set.contains(pre)) {
                continue;
            }
            var count = 0;
            var cur = n;
            while (set.contains(cur)) {
                count++;
                cur++;
            }
            res = Math.max(res, count);
        }
        return res;
    }
}
