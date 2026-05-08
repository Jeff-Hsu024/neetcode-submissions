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
        for (int i = bucket.length - 1; i >= 0; i--) {
            var ls = bucket[i];
            if (null == ls) {
                continue;
            }
            for (int j = ls.size() - 1; j >= 0; j--) {
                res[k - 1] = ls.get(j);
                k--;
                if (k == 0) {
                    return res;
                }
            }
        }
        return res;
    }
}
