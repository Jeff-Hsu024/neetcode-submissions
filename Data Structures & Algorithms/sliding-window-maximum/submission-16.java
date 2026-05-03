class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        var len = nums.length;
        int[] res = new int[len - k + 1];

        Deque<Integer> d = new ArrayDeque<>();

        for (int i = 0; i < len; i++) {
            var num = nums[i];
            // 0 = 2 - 3  + 1
            int resIdx = i - k + 1;
            // out of window
            // int d_first_idx = d.peekFirst();
            if (!d.isEmpty() && d.peekFirst() < resIdx) {
                d.pollFirst();
            }

            // poll start last
            // int d_last_val = nums[d.peekLast()] might null
            while (!d.isEmpty() && nums[d.peekLast()] < num) {
                d.pollLast();
            }

            d.offer(i);

            if (resIdx >= 0) {
                int d_first_val = nums[d.peekFirst()];
                res[resIdx] = d_first_val;
            }
        }

        return res;
    }
}
