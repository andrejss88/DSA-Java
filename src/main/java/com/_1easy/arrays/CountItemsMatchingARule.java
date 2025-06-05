package com._1easy.arrays;

import java.util.List;

/**
 * 1773
 * You are given an array items, where each items[i] = [typei, colori, namei] describes the type, color, and name of the ith item. You are also given a rule represented by two strings, ruleKey and ruleValue.
 * The ith item is said to match the rule if one of the following is true:
 * <p>
 * ruleKey == "type" and ruleValue == typei.
 * ruleKey == "color" and ruleValue == colori.
 * ruleKey == "name" and ruleValue == namei.
 * Return the number of items that match the given rule.
 * Example 1:
 * <p>
 * Input: items = [["phone","blue","pixel"],["computer","silver","lenovo"],["phone","gold","iphone"]], ruleKey = "color", ruleValue = "silver"
 * Output: 1
 * Explanation: There is only one item matching the given rule, which is ["computer","silver","lenovo"].
 */
public class CountItemsMatchingARule {

    // 4ms, Beats 86%
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {

        int count = 0;

        int key = switch (ruleKey) {
            case "type" -> 0;
            case "color" -> 1;
            default -> 2;
        };

        for (var item : items) {
            if (item.get(key).equals(ruleValue)) count++;
        }
        return count;
    }
}
