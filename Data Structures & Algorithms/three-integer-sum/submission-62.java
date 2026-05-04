class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            var num = nums[i];
            if (num > 0) {
                break;
            }
            if (i > 0 && num == nums[i - 1]) {
                continue;
            }

            int l = i + 1;
            int r = nums.length - 1;

            while (l < r) {
                var sum = num + nums[l] + nums[r];
                if (sum == 0) {
                    res.add(List.of(num, nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) {
                        l = l + 1;
                    }
                    l = l + 1;
                    while (l < r && nums[r] == nums[r - 1]) {
                        r = r - 1;
                    }
                    r = r - 1;
                }

                if (sum < 0) {
                    while (l < r && nums[l] == nums[l + 1]) {
                        l = l + 1;
                    }
                    l = l + 1;
                }

                if (sum > 0) {
                    while (l < r && nums[r] == nums[r - 1]) {
                        r = r - 1;
                    }
                    r = r - 1;
                }
            }
        }

        return res;
    }
}
