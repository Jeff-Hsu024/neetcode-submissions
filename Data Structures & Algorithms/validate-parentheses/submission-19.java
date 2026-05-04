class Solution {
    public boolean isValid(String s) {
        var chars = s.toCharArray();
        if (chars.length % 2 != 0) {
            return false;
        }
        Map<Character, Character> pairs = Map.of('}', '{', ']', '[', ')', '(');
        Stack<Character> stack = new Stack<>();
        for (var c : chars) {
            if (pairs.containsKey(c)) {
                if (stack.isEmpty()) {
                    return false;
                }
                var last = stack.pop();
                var expect = pairs.get(c);
                if (last != expect) {
                    return false;
                }

            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
