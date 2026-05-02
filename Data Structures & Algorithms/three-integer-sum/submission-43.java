class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();

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
                var lnum = nums[l];
                var rnum = nums[r];
                var sum = num + lnum + rnum;

                if (sum == 0) {
                    res.add(List.of(num, lnum, rnum));

                    while (l < r && lnum == nums[l]) {
                        l = l + 1;
                    }

                    while (l < r && rnum == nums[r]) {
                        r = r - 1;
                    }
                }

                if (sum < 0) {
                    l = l + 1;
                }

                if (sum > 0) {
                    r = r - 1;
                }
            }
        }
        return res;
    }
}
