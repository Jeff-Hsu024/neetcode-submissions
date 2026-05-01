class Solution {
    public boolean hasDuplicate(int[] nums) {
        if (nums.length <= 1) {
            return false;
        } 

        Set<Integer> set = new HashSet<>();
        for(int num: nums) {
            boolean added = set.add(num);
            if (!added) {
                return true;
            }
        }

        return false;
    }
}