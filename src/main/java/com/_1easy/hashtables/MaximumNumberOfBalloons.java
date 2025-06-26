package com._1easy.hashtables;

import java.util.HashMap;
import java.util.Map;

/**
 * 1189
 * Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.
 * You can use each character in text at most once. Return the maximum number of instances that can be formed.
 * <p>
 * Example 2:
 * Input: text = "loonbalxballpoon"
 * Output: 2
 * <p>
 * Example 3:
 * Input: text = "leetcode"
 * Output: 0
 */
public class MaximumNumberOfBalloons {

    public static void main(String[] args) {
        System.out.println(maxNumberOfBalloonsFaster("krhizmmgmcrecekgyljqkldocicziihtgpqwbticmvuyznragqoyrukzopfmjhjjxemsxmrsxuqmnkrzhgvtgdgtykhcglurvppvcwhrhrjoislonvvglhdciilduvuiebmffaagxerjeewmtcwmhmtwlxtvlbocczlrppmpjbpnifqtlninyzjtmazxdbzwxthpvrfulvrspycqcghuopjirzoeuqhetnbrcdakilzmklxwudxxhwilasbjjhhfgghogqoofsufysmcqeilaivtmfziumjloewbkjvaahsaaggteppqyuoylgpbdwqubaalfwcqrjeycjbbpifjbpigjdnnswocusuprydgrtxuaojeriigwumlovafxnpibjopjfqzrwemoinmptxddgcszmfprdrichjeqcvikynzigleaajcysusqasqadjemgnyvmzmbcfrttrzonwafrnedglhpudovigwvpimttiketopkvqw"));
    }

    // 2ms, Beats 91%
    public static int maxNumberOfBalloonsFaster(String text) {

        int[] freqArr = new int[26];
        for (char c : text.toCharArray()) {
            freqArr[c - 'a']++;
        }

        int balloonCount = Integer.MAX_VALUE;
        int[] balloonFreqArr = new int[5];
        balloonFreqArr[0] = freqArr['b' - 'a'];
        balloonFreqArr[1] = freqArr['a' - 'a'];
        balloonFreqArr[2] = freqArr['l' - 'a'];
        balloonFreqArr[3] = freqArr['o' - 'a'];
        balloonFreqArr[4] = freqArr['n' - 'a'];

        for (int i = 0; i < balloonFreqArr.length; i++) {
            int frequency = balloonFreqArr[i];
            if (i == 2 || i == 3) {  // if 'l' or 'o'
                frequency = frequency / 2;
            }
            balloonCount = Math.min(balloonCount, frequency);
        }
        return balloonCount;
    }

    // 6ms, Beats 56% Runtime
    public static int maxNumberOfBalloons(String text) {

        Map<Character, Integer> map = new HashMap<>();

        for (char c : text.toCharArray()) {
            if (c == 'b' || c == 'a' || c == 'l' || c == 'o' || c == 'n') {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }

        if (map.size() != 5 || map.get('l') < 2 || map.get('o') < 2) {
            return 0;
        }

        int balloonCount = Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int letter = entry.getKey();
            int frequency = entry.getValue();
            if (frequency == 0) return 0;

            if (letter == 'l' || letter == 'o') {
                frequency = frequency / 2;
            }

            balloonCount = Math.min(balloonCount, frequency);
        }

        return balloonCount;
    }
}
