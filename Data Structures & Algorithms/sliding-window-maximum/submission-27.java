class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int[] res = new int[len - k + 1];
        Deque<Integer> d = new ArrayDeque<>();

        for (int i = 0; i < len; i++) {
            int resIdx = i - k + 1;
            var num = nums[i];

            // took out off window, resIdx also mean the chunk first index.
            if (!d.isEmpty() && d.peekFirst() < resIdx) {
                d.pollFirst();
            }

            // took min from last(s).
            while (!d.isEmpty() && nums[d.peekLast()] < num) {
                d.pollLast();
            }

            d.offer(i);

            if (resIdx >= 0) {
                res[resIdx] = nums[d.peekFirst()];
            }
        }

        return res;
    }
}
