class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            var n = nums[i];
            if (n > 0) {
                break;
            }
            if (i > 0 && n == nums[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                var ln = nums[l];
                var rn = nums[r];
                var sum = n + ln + rn;
                if (sum == 0) {
                    res.add(List.of(n, ln, rn));
                    while (l < r && ln == nums[l]) {
                        l++;
                    }
                    while (l < r && rn == nums[r]) {
                        r--;
                    }
                }
                if (sum < 0) {
                    while (l < r && ln == nums[l]) {
                        l++;
                    }
                }
                if (sum > 0) {
                    while (l < r && rn == nums[r]) {
                        r--;
                    }
                }
            }
        }

        return res;
    }
}
