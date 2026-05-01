class Solution {
        public boolean hasDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            boolean added = set.add(num);
            if (!added) {
                return true;
            }
        }

        return false;   
    }
}