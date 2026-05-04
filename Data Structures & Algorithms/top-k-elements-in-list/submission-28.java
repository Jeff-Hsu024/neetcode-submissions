class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        // count
        for (var num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // bucket
        // every counter, begin from 0;
        List<Integer>[] buckets = new List[nums.length + 1];
        for (int i= 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (var entry: map.entrySet()) {
            buckets[entry.getValue()].add(entry.getKey());
        }

        int[] res = new int[k];
        int resIdx = k - 1;
        for (int i = buckets.length - 1; i >= 0; i--) {
            var bucket = buckets[i];
            if (bucket.isEmpty()) {
                continue;
            }

            for (int j = bucket.size() - 1; j >=0 ; j--) {
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
