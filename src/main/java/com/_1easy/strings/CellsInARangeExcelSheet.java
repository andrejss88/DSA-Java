package com._1easy.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * 2194
 * Example 1:
 * Input: s = "K1:L2"
 * Output: ["K1","K2","L1","L
 * <p>
 * Example 2:
 * Input: s = "A1:F1"
 * Output: ["A1","B1","C1","D1","E1","F1"]
 */
public class CellsInARangeExcelSheet {

    // beats 80% runtime, 72% memory
    // the s.split(":"); in v1 makes the difference
    // Since we know the exact format of input String, we can charAt() directly
    public static List<String> cellsInRange(String s) {

//        String[] cells = s.split(":");

        char startChar = s.charAt(0);
        char startInt = s.charAt(1);

        char finishChar = s.charAt(3);
        char finishInt = s.charAt(4);

        char resetValue = startInt;

        List<String> list = new ArrayList<>();

        while (startChar <= finishChar) {
            var cell = new String(new char[]{startChar, startInt});
            list.add(cell);
            if (startInt < finishInt) {
                startInt++;
            } else {
                startChar++; // we can move ++ a char to move it along the alphabet
                startInt = resetValue;
            }
        }
        return list;
    }
}
