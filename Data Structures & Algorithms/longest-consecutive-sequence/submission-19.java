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
            var next = num + 1;
            if (set.contains(next)) {
                int temp = 2;
                if (temp > max) {
                        max = temp;
                    }
                while (set.contains(next + 1)) {
                    temp = temp + 1;
                    if (temp > max) {
                        max = temp;
                    }
                    next = next + 1;
                }
            }
        }

        return max;
    }
}
