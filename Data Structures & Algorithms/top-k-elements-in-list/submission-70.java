class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (var n:nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        List<Integer>[] buckets = new List[nums.length + 1];
        for (var entry: map.entrySet()) {
            var n = entry.getKey();
            var c = entry.getValue();
            if (buckets[c] == null) {
                buckets[c] = new ArrayList<>();
            }
            buckets[c].add(n);
        }

        int[] res = new int[k];
        for (int i = buckets.length - 1; i >=0 ; i--) {
            var ls = buckets[i];
            if (ls == null) {
                continue;
            }

            for (int j = ls.size() - 1; j >=0; j--) {
                var n = ls.get(j);
                res[k-1] = n;
                k = k -1;
                if (k == 0) {
                    return res;
                }
            }
        }
        return res;
    }
}
