class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (var num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] bucket = new List[nums.length + 1];
        for (var entry : map.entrySet()) {
            var num = entry.getKey();
            var count = entry.getValue();

            if (bucket[count] == null) {
                bucket[count] = new ArrayList<>();
            }
            bucket[count].add(num);
        }

        int[] res = new int[k];
        for (int i = bucket.length - 1; i >= 0; i--) {
            var ls = bucket[i];
            if (ls == null) {
                continue;
            }
            for (int j = ls.size() - 1; j >= 0; j--) {
                res[k - 1] = ls.get(j);
                k = k - 1;
                if (k == 0) {
                    return res;
                }
            }
        }

        return res;
    }
}
