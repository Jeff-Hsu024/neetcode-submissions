class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set =new HashSet<>();

        for (var num: nums) {
            set.add(num);
        }

        int res = 0;

        for (int i = 0; i < nums.length; i ++) {
            var num = nums[i];
            if (set.contains(num - 1)) {
                continue;
            }
            var cur = num;
            var count = 0;
            while(set.contains(cur)) {
                cur++;
                count++;
            }
            res = Math.max(res, count);
        }


        return res;
    }
}
