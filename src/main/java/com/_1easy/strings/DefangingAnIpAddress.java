package com._1easy.strings;

/**
 * 1108
 * Given a valid (IPv4) IP address, return a defanged version of that IP address.
 * A defanged IP address replaces every period "." with "[.]".
 * <p>
 * Example 1:
 * <p>
 * Input: address = "1.1.1.1"
 * Output: "1[.]1[.]1[.]1"
 * Example 2:
 * <p>
 * Input: address = "255.100.50.0"
 * Output: "255[.]100[.]50[.]0"
 */
public class DefangingAnIpAddress {

    public static String defangIPaddr(String address) {
        var sb = new StringBuilder();
        char[] chars = address.toCharArray();

        for (char character : chars) {
            if (character == '.') {
                sb.append('[').append(character).append(']');
            } else {
                sb.append(character);
            }
        }
        return sb.toString();
    }
}
