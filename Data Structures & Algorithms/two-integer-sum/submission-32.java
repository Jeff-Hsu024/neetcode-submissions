class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            var num = nums[i];
            var want = target - num;
            if (map.containsKey(want)) {
                return new int[] {
                    map.get(want), i
                };
            }

            map.put(num, i);
        }

        return new int[2];
    }
}
