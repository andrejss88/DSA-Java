package com._1easy.arrays;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * 682
 */
public class BaseballGame {

    public static void main(String[] args) {

        System.out.println(calPointsFastest(new String[]{"5","-2","4","C","D","9","+","+"}));  // 27
        System.out.println(calPointsFastest(new String[]{"5", "2", "C", "D", "+"}));  //30

    }

    // 2ms, Beats Runtime 94%
    // main speed up reason is computing sum on the fly
    public static int calPointsFastest(String[] operations) {

        Deque<Integer> stack = new ArrayDeque<>();

        int sum = 0;

        for (String s : operations) {
            char op = s.charAt(0);

            if (op == 'C') {
                int last = stack.removeLast();
                sum -= last;
            } else if (op == 'D') {
                int last = stack.peekLast();
                int doubled = last * 2;
                sum += doubled;
                stack.add(doubled);
            } else if (op == '+') {
                int first = stack.removeLast();
                int second = stack.removeLast();
                int added = first + second;
                sum += added;
                stack.add(second);
                stack.add(first);
                stack.add(added);
            } else {
                int num = Integer.parseInt(s);
                sum += num;
                stack.add(num);
            }
        }

        return sum;
    }


    // 4ms - Massive improvement, but still one of the slowest (Beats Runtime 11%)
    public static int calPointsFaster(String[] operations) {

        Deque<Integer> stack = new ArrayDeque<>();

        for (String operation : operations) {
            char op = operation.charAt(0);

            if (op == 'C') {
                // remove
                stack.removeLast();
            } else if (op == 'D') {
                int last = stack.removeLast();
                stack.addAll(List.of(last, last * 2));
            } else if (op == '+') {
                // sum of previous two
                int first = stack.removeLast();
                int second = stack.removeLast();
                stack.addAll(List.of(second, first, first + second));

            } else {
                int num = Integer.parseInt(operation);
                stack.add(num);
            }
        }

        return stack.stream().reduce(Integer::sum).orElse(0);
    }

    // 25ms - slowest imaginable
    // Avoid using try-catch to determine type whenever possible
    public static int calPoints(String[] operations) {

        Deque<Integer> stack = new ArrayDeque<>();
        Object input = null;

        for (String operation : operations) {
            try {
                input = Integer.parseInt(operation);
            } catch (NumberFormatException e) {
                input = operation.charAt(0);
            }

            switch (input) {
                case Integer i -> stack.add(i);
                case Character c when c == '+' -> {
                    int first = stack.removeLast();
                    int second = stack.removeLast();
                    stack.addAll(List.of(second, first, first + second));
                }
                case Character c when c == 'D' -> {
                    int last = stack.removeLast();
                    stack.addAll(List.of(last, last * 2));
                }
                // 'C'
                default -> stack.removeLast();
            }
        }

        return stack.stream().reduce(Integer::sum).orElse(0);
    }
}
