class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> pair = Map.of(']', '[', ')', '(', '}', '{');

        Stack<Character> stack = new Stack<>();

        for (var c : s.toCharArray()) {
            if (pair.containsKey(c)) {
                if (stack.isEmpty()) {
                    return false;
                }
                var last = stack.pop();
                var expect = pair.get(c);
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
