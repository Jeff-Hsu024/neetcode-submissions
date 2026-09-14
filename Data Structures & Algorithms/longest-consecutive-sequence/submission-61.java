class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (var n:nums) {
            set.add(n);
        }
        int res = 0;
        for (var n:set) {
            var pre = n - 1;
            var hasPre = set.contains(pre);
            if (hasPre) {
                continue;
            }
            
            int c = 0;
            int cur = n;
            while (set.contains(cur)) {
                c = c + 1;
                cur = cur + 1;
            }
            res = Math.max(res, c);
        }

        return res;
    }
}
