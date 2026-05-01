class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == 1) {
            return nums;
        }

        int[] res = new int[k];

        Map<Integer, Integer> countMap = new HashMap<>();
        for (var num : nums) {
            countMap.putIfAbsent(num, 0);
            countMap.put(num, countMap.get(num) + 1);
        }

        // reverse count
        var entries =
            countMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).toList();

        for (int i = 0; i < res.length; i++) {
            res[i] = entries.get(i).getKey();
        }

        return res;
    }
}
