class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();

        for (var num : nums) {
            count.putIfAbsent(num, 0);
            count.put(num, count.get(num) + 1);
        }

        var descLs = count.entrySet()
                         .stream()
                         .sorted((a, b) -> b.getValue() - a.getValue())
                         .map(e -> e.getKey())
                         .toList();

        int[] res = new int[k];
        for (int i = 0; i < res.length; i++) {
            res[i] = descLs.get(i);
        }

        return res;
    }
}
