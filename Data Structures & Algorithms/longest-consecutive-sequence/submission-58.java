class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (var num : nums) {
            set.add(num);
        }

        int res = 0;

        for (var num : set) {
            var pre = num - 1;
            if (set.contains(pre)) {
                continue;
            }
            var cur = num;
            var count = 0;
            while (set.contains(cur)) {
                cur = cur + 1;
                count = count + 1;
            }

            res = Math.max(res, count);
        }
        return res;
    }
}
