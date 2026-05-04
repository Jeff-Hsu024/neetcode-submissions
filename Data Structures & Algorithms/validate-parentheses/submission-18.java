class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> pairs = Map.of(')', '(', '}', '{', ']', '[');
        var chars = s.toCharArray();
        var len = chars.length;

        if (len % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for (var c : chars) {
            if (pairs.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != pairs.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}
