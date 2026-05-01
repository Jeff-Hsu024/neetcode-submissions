class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Arrays.sort(nums);

        Map<Integer, Integer> map = new HashMap<>();

        for (var num : nums) {
            map.putIfAbsent(num, 0);
            map.put(num, map.get(num) + 1);
        }

        var sortedList =
            map
            .entrySet()
            .stream()
            .sorted((o1, o2) -> o2.getValue() - o1.getValue())
            .toList();

        int[] res = new int[k];
        for (int i = 0; i < res.length; i++) {
            res[i] = sortedList.get(i).getKey();
        }

        return res;
    }
}
