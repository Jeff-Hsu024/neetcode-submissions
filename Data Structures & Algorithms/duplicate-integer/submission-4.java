class Solution {
    public boolean hasDuplicate(int[] nums) {
        if (nums.length <= 1) {
            return false;
        }

        Set<Integer> set = new HashSet<>();
        for(var num: nums) {
            var added = set.add(num);
            if (!added) {
                return true;
            }
        }

        return false;
    }
}