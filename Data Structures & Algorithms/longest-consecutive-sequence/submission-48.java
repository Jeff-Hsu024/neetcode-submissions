class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (var n: nums) {
            set.add(n);
        }

        int res = 0;
        for (var n : set) {
            // has previous n
            if (set.contains(n - 1)) {
                continue;
            }

            int cur = n;
            int count = 0;
            while (set.contains(cur)) {
                cur = cur + 1;
                count = count + 1;
            }

            res = Math.max(res, count);
        }

        return res;
    }
}
