package com._1easy.strings;

/**
 * 1678
 * Example 1:
 * <p>
 * Input: command = "G()(al)"
 * Output: "Goal"
 * Explanation: The Goal Parser interprets the command as follows:
 * G -> G
 * () -> o
 * (al) -> al
 * The final concatenated result is "Goal".
 * Example 2:
 * <p>
 * Input: command = "G()()()()(al)"
 * Output: "Gooooal"
 */
public class GoalParserInterpretation {

    // 0ms, Beats 100%
    public String interpret(String command) {

        var sb = new StringBuilder();
        for (int i = 0; i < command.length(); i++) {
            char ch = command.charAt(i);

            if (ch == 'G') {
                sb.append(ch);
            } else if (ch == '(' && command.charAt(i + 1) == ')') {
                sb.append('o');
                i++;
            } else {
                sb.append("al");
                i += 3;
            }
        }

        return new String(sb);
    }
}
