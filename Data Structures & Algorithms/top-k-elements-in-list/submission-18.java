class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // freq
        Map<Integer, Integer> map = new HashMap<>();
        for (var num : nums) {
            map.putIfAbsent(num, 0);
            map.put(num, map.get(num) + 1);
        }

        // sort
        var ls = map.entrySet()
                     .stream()
                     .sorted((a, b) -> b.getValue() - a.getValue())
                     .map(e -> e.getKey())
                     .toList();

        int[] res = new int[k];
        for (int i = 0; i < res.length; i++) {
            res[i] = ls.get(i);
        }

        return res;
    }
}

