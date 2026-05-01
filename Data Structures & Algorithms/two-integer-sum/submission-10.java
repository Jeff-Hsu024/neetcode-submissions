class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length ; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length ; i++) {
            var num = nums[i];
            var wantend = target - num;
            if (map.get(wantend) != null && i != map.get(wantend)) {
                return new int[] {i, map.get(wantend)};
            }
        }

        return res;
    }
}
