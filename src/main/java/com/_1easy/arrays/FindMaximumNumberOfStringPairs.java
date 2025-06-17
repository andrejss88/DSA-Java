package com._1easy.arrays;

/**
 * 2744
 */
public class FindMaximumNumberOfStringPairs {

    public static void main(String[] args) {
        System.out.println(maximumNumberOfStringPairsFaster(new String[]{"cy","ht","gc","ei","ie","yc","th","cg","kz"}));

        String ss = "ab";
        System.out.println(new String(new char[]{ss.charAt(1), ss.charAt(0)}));
    }

    // 3ms, Beats 80%
    // can be even faster if we compare individual chars of both words
    // ie wordOneFirstChar == wordTwoSecondChar && ...
    public static int maximumNumberOfStringPairsFaster(String[] words) {
        int count = 0;
        for(int i = 0; i < words.length; i++) {
            String wordOne = words[i];
            for(int j = i + 1; j < words.length; j++) {
                String wordTwo = words[j];
                String reversed = new String(new char[]{wordTwo.charAt(1), wordTwo.charAt(0)});
                if(wordOne.equals(reversed)) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
    // 5ms, Beats 56%
    public static int maximumNumberOfStringPairs(String[] words) {

        int count = 0;
        var sb = new StringBuilder();
        for(int i = 0; i < words.length; i++) {
            String wordOne = words[i];
            for(int j = i + 1; j < words.length; j++) {
                String wordTwo = words[j];
                String reversed = sb.append(wordTwo).reverse().toString();
                if(wordOne.equals(reversed)) {
                    count++;
                    sb.setLength(0);
                    break;
                }
                sb.setLength(0);
            }
        }
        return count;
    }
}
