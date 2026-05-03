class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        var len = nums.length;
        int[] res = new int[len - k + 1];

        Deque<Integer> d = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            var resIdx = i - k + 1;
            var num = nums[i];

            if (!d.isEmpty() && d.peekFirst() < resIdx) {
                d.pollFirst();
            }

            while (!d.isEmpty() && num >= nums[d.peekLast()]) {
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
