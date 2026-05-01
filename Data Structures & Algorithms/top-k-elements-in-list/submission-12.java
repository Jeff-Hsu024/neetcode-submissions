class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];

        Map<Integer, Integer> countMap = new HashMap<>();
        for (var num : nums) {
            countMap.putIfAbsent(num, 0);
            countMap.put(num, countMap.get(num) + 1);
        }

        var sortedEntries =
            countMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).toList();

        for (int i = 0; i < res.length; i++) {
            res[i] = sortedEntries.get(i).getKey();
        }

        return res;
    }
}
