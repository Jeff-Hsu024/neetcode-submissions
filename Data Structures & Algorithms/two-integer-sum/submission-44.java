class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[] {};
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            var num = nums[i];
            var want = target - num;
            if (map.containsKey(want)) {
                var j = map.get(want);
                return new int[] {j, i};
            }
            map.put(num, i);
        }

        return res;
    }
}
