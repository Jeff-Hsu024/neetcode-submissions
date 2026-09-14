class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (var n:nums) {
            var added = set.add(n);
            if (!added) {
                return true;
            }
        }
        return false;
    
    }
}