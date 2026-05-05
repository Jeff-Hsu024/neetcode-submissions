class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        var len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (var num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] count = new List[len + 1];
        for (var entry : map.entrySet()) {
            var num = entry.getKey();
            var numc = entry.getValue();
            if (null == count[numc]) {
                count[numc] = new ArrayList<>();
            }
            count[numc].add(num);
        }

        int[] res = new int[k];
        int collect = k;
        for (int i = count.length - 1; i >= 0; i--) {
            var numls = count[i];
            if (null == numls || numls.isEmpty()) {
                continue;
            }
            for (int j = numls.size() - 1; j >= 0; j--) {
                var num = numls.get(j);
                collect = collect - 1;
                if (collect < 0) {
                    break;
                }
                res[collect] = num;
            }
        };
        return res;
    }
}
