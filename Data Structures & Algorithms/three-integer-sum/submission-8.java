class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num > 0) {
                continue;
            }
            if (i > 0 && num == nums[i - 1]) {
                continue;
            }

            int ascWalkerPos = i + 1;
            int descWalkerPos = nums.length - 1;
            while (descWalkerPos > ascWalkerPos) {
                var ascNum = nums[ascWalkerPos];
                var descNum = nums[descWalkerPos];
                var sum = num + ascNum + descNum;

                if (sum == 0) {
                    result.add(List.of(num, ascNum, descNum));

                    while (descWalkerPos > ascWalkerPos && ascNum == nums[ascWalkerPos]) {
                        ascWalkerPos = ascWalkerPos + 1;
                    }

                    while (descWalkerPos > ascWalkerPos && descNum == nums[descWalkerPos]) {
                        descWalkerPos = descWalkerPos - 1;
                    }
                }
                if (sum < 0) {
                    ascWalkerPos = ascWalkerPos + 1;
                }
                if (sum > 0) {
                    descWalkerPos = descWalkerPos - 1;
                }
            }

        }

        return result;
    }
}
