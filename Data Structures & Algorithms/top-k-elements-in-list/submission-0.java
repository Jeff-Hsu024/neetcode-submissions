class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == k) {
            return nums;
        }

        int[] result = new int[k];
        Arrays.sort(nums);

        Map<Integer, Integer> countMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            var num = nums[i];
            countMap.putIfAbsent(num, 0);
            var count = countMap.get(num);
            count = count + 1;
            countMap.put(num, count);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>(
                (a, b) -> a.getValue() - b.getValue());

        countMap.entrySet().forEach(entry -> {
            priorityQueue.offer(entry);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        });

        for (int i = 0; i < result.length; i++) {
            result[i] = priorityQueue.poll().getKey();
        }

        return result;
    }
}
