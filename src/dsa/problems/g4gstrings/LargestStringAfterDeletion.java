package dsa.problems.g4gstrings;

public class LargestStringAfterDeletion {
    public static void main(String[] args) {
        System.out.println(maxSubseq("ritz", 2));
        System.out.println(maxSubseq("zebra", 3));
    }


    public static String maxSubseq(String s, int k) {
        //int n = s.length();
        int toRemove = k;
        StringBuilder stack = new StringBuilder();

        for (char c : s.toCharArray()) {

            while (toRemove > 0
                    && !stack.isEmpty()
                    && stack.charAt(stack.length() - 1) < c) {
                stack.deleteCharAt(stack.length() - 1);
                toRemove--;
            }
            stack.append(c);
        }
        if (toRemove > 0) {
            stack.setLength(stack.length() - toRemove);
        }
        return stack.toString();
    }

}
