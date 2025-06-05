package com._1easy.arrays;

import java.util.Arrays;

/**
 * 2037
 */
public class MinimumNumberOfSeatsToSeatEveryone {

    public static void main(String[] args) {

        System.out.println(minMovesToSeatFaster(new int[]{1, 100}, new int[]{1, 5})); // 95
        System.out.println(minMovesToSeatFaster(new int[]{3, 1, 5}, new int[]{2, 7, 4})); // 4
        System.out.println(minMovesToSeatFaster(new int[]{12, 14, 19, 19, 12}, new int[]{19, 2, 17, 20, 7})); // 19
        System.out.println(minMovesToSeatFaster(new int[]{2, 2, 6, 6}, new int[]{1, 3, 2, 6})); // 4
    }
    //                    2              7             12    14        17   19  20
// stud        [0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0,
// seat        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 1, 0, 0, 0, 0, 2, 0, 0,

    // 2ms, Beats 95%
    public static int minMovesToSeatFaster(int[] seats, int[] students) {

        int[] seatsFreqArr = new int[101];
        int[] studentsFreqArr = new int[101];

        for (int num : seats) {
            seatsFreqArr[num] = ++seatsFreqArr[num];
        }
        for (int num : students) {
            studentsFreqArr[num] = ++studentsFreqArr[num];
        }

        int moves = 0;
        int studentIndx = 0;
        int seatsIndx = 0;
        int end = studentsFreqArr.length;

        while (studentIndx < end && seatsIndx < end) {

            int studentVal = studentsFreqArr[studentIndx];
            int seatVal = seatsFreqArr[seatsIndx];

            // student 0, seats 0       -> continue looping over students AND seats
            if (studentVal == 0 && seatVal == 0) {
                studentIndx++;
                seatsIndx++;
                continue;
                // student 1+, seats 1+     -> continue getting values for both student and seats WITHOUT moving forward
            } else if (studentVal != 0 && seatVal != 0) {
                moves += Math.abs(seatsIndx - studentIndx);
                // deduct from both
                studentsFreqArr[studentIndx] = --studentVal;
                seatsFreqArr[seatsIndx] = --seatVal;
                continue;
                // we DON'T move indexes forward yet, we might have 1 and 1 still left
                // in which case we will reach this statement again

                // student 1+, seats 0       -> keep looping over seats until non-0,
            } else if (studentVal != 0) {
                // take current seatIndex, and keep looping until non-0 val, update the seatIndex and BREAK to outer
                for (int j = seatsIndx; j <= seatsFreqArr.length; j++) {
                    if (seatsFreqArr[j] != 0) {
                        seatsIndx = j;
                        break;
                    }
                }
            }
            // student 0, seats 1+      -> continue looping over students, stay on seats
            else {  // if seatsVal != 0
                // take current studentIndex, and keep looping until non-0 val, update the studentIndex and BREAK to outer
                for (int j = studentIndx; j < studentsFreqArr.length; j++) {
                    if (studentsFreqArr[j] != 0) {
                        studentIndx = j;
                        break;
                    }
                }
            }
        }
        return moves;
    }

    // 3ms, Beats Runtime 63% - O(n log n)
    public static int minMovesToSeat(int[] seats, int[] students) {

        int moves = 0;
        Arrays.sort(seats);
        Arrays.sort(students);

        for (int i = 0; i < seats.length; i++) {
            moves += Math.abs(seats[i] - students[i]);
        }

        return moves;
    }
}
