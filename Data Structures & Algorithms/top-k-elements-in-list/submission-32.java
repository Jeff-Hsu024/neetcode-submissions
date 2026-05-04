class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        // count
        for (var num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] buckets = new List[nums.length + 1];

        for (var entry: map.entrySet()) {
            var bucket = buckets[entry.getValue()];
            if (null == bucket) {
                buckets[entry.getValue()] = new ArrayList<>();
            }

            buckets[entry.getValue()].add(entry.getKey());
        }

        int[] res = new int[k];
        int resIdx = res.length - 1;

        for (int i = buckets.length - 1; i >= 0; i--) {
            var bucket = buckets[i];
            if (null == bucket || bucket.isEmpty()) {
                continue;
            }
            for (int j = bucket.size() - 1; j >=0; j--) {
                var n = bucket.get(j);
                res[resIdx] = n;
                resIdx = resIdx - 1;
                if (resIdx < 0) {
                    return res;
                }

            }
        }

        return res;

    }
}
