class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];

        Map<Integer, Integer> map = new HashMap<>();
        for (var num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        var descLs = map.entrySet()
                         .stream()
                         .sorted((a, b) -> b.getValue() - a.getValue())
                         .map(e -> e.getKey())
                         .toList();

        for (int i =0; i< res.length; i++) {
            res[i] = descLs.get(i);
        }

        return res;
    }
}
