package JAVA.LeadCode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/*
2182. Construct String With Repeat Limit
You are given a string s and an integer repeatLimit. Construct a new string repeatLimitedString using the characters of s such that no letter appears more than repeatLimit times in a row. You do not have to use all characters from s.

Return the lexicographically largest repeatLimitedString possible.

A string a is lexicographically larger than a string b if in the first position where a and b differ, string a has a letter that appears later in the alphabet than the corresponding letter in b. If the first min(a.length, b.length) characters do not differ, then the longer string is the lexicographically larger one.



Example 1:

Input: s = "cczazcc", repeatLimit = 3
Output: "zzcccac"
Explanation: We use all of the characters from s to construct the repeatLimitedString "zzcccac".
The letter 'a' appears at most 1 time in a row.
The letter 'c' appears at most 3 times in a row.
The letter 'z' appears at most 2 times in a row.
Hence, no letter appears more than repeatLimit times in a row and the string is a valid repeatLimitedString.
The string is the lexicographically largest repeatLimitedString possible so we return "zzcccac".
Note that the string "zzcccca" is lexicographically larger but the letter 'c' appears more than 3 times in a row, so it is not a valid repeatLimitedString.
Example 2:

Input: s = "aababab", repeatLimit = 2
Output: "bbabaa"
Explanation: We use only some of the characters from s to construct the repeatLimitedString "bbabaa".
The letter 'a' appears at most 2 times in a row.
The letter 'b' appears at most 2 times in a row.
Hence, no letter appears more than repeatLimit times in a row and the string is a valid repeatLimitedString.
The string is the lexicographically largest repeatLimitedString possible so we return "bbabaa".
Note that the string "bbabaaa" is lexicographically larger but the letter 'a' appears more than 2 times in a row, so it is not a valid repeatLimitedString.
*/
public class RepeatLimitedString {

    public static void main(String[] args) {
        int repeatLimit = 2;
        String s = "aababab";
        System.out.println(RepeatLimitedString.repeatLimitedString(s,repeatLimit));
    }

    public static String repeatLimitedString(String s, int repeatLimit) {
        int[] freq = new int[26]; for (char c : s.toCharArray()) { freq[c - 'a']++; }
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < 26; i++) { if (freq[i] > 0) { pq.add((char) (i + 'a')); } }
        StringBuilder result = new StringBuilder();
        while (!pq.isEmpty()) {
            char current = pq.poll();
            int currentFreq = freq[current - 'a'];
            int useFreq = Math.min(currentFreq, repeatLimit);
            for (int i = 0; i < useFreq; i++) { result.append(current); }
            if (currentFreq > useFreq) { if (pq.isEmpty()) break;
                char next = pq.poll(); result.append(next);
                if (--freq[next - 'a'] > 0) { pq.add(next); }
                freq[current - 'a'] -= useFreq;
                pq.add(current); } }
        return result.toString();
    }
}
