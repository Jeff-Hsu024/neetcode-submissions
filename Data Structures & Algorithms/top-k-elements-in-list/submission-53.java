class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (var n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        List<Integer>[] bucket = new List[nums.length + 1];
        for (var entry : map.entrySet()) {
            var n = entry.getKey();
            var c = entry.getValue();
            if (bucket[c] == null) {
                bucket[c] = new ArrayList<>();
            }
            bucket[c].add(n);
        }

        int[] res = new int[k];
        int resIdx = k - 1;
        for (int i = bucket.length - 1; i >= 0; i--) {
            var ls = bucket[i];
            if (ls ==null || ls.isEmpty()) {
                continue;
            }
            for (int j = ls.size() - 1; j >= 0; j--) {
                res[resIdx] = ls.get(j);
                resIdx--;
                if (resIdx < 0) {
                    return res;
                }
            }
        }
        return res;
    }
}
