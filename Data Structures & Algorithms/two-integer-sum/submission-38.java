class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i =0; i < nums.length; i++) {
            var n = nums[i];
            var want = target - n;
            if (map.containsKey(want)) {
                return new int[] {map.get(want), i};
            }
            map.put(n, i);
        }

        return new int[2];
    }
}
