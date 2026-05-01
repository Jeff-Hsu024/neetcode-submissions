class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length ; i++) {
            var num = nums[i];
            var wantend = target - num;
            if (map.get(wantend) != null) {
                return new int[] {map.get(wantend), i};
            } else {
                map.put(nums[i], i);
            }
        }

        return res;
    }
}
