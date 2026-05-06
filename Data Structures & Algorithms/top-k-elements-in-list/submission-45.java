class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (var n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        List<Integer>[] buckets = new List[nums.length + 1];

        for (var entry : map.entrySet()) {
            var n = entry.getKey();
            var c = entry.getValue();
            if (null == buckets[c]) {
                buckets[c] = new ArrayList<>();
            }
            buckets[c].add(n);
        }

        int[] res = new int[k];
        int collect = k - 1;
        for (int i = buckets.length - 1; i >= 0; i--) {
            if (null == buckets[i]) {
                continue;
            }
            var ls = buckets[i];
            for (int j = ls.size() - 1; j >= 0; j--) {
                res[collect] = ls.get(j);
                collect = collect - 1;
                if (collect < 0) {
                    return res;
                }
            }
        }
        return res;
    }
}
