class Solution {
    public boolean hasDuplicate(int[] nums) {
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