class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        List<String> handledStrList = new ArrayList<>();

        for (int i = 0; i < strs.length; i++) {
            var handleStr = strs[i];
            if (handledStrList.contains(handleStr)) {
                continue;
            }
            handledStrList.add(handleStr);
            List<String> subList = new ArrayList<>();
            subList.add(handleStr);
            for (int j = i + 1; j < strs.length; j++) {
                var otherStr = strs[j];
                var isAnagram = isAnagramHelper(handleStr, otherStr);
                if (isAnagram) {
                    handledStrList.add(otherStr);
                    subList.add(otherStr);
                }
            }
            result.add(subList);
        }
        return result;
    }

    private boolean isAnagramHelper(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        var sCharArray = s.toCharArray();
        var tCharArray = t.toCharArray();

        Arrays.sort(sCharArray);
        Arrays.sort(tCharArray);

        for (int i = 0; i < tCharArray.length; i++) {
            var sChar = sCharArray[i];
            var tChar = tCharArray[i];
            if (sChar != tChar) {
                return false;
            }
        }
        return true;
    }
}
