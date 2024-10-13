package JAVA.LeadCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubstringConcatenation {
    public static void main(String[] args) {

        String [] words = {"word","good","best","word"};
        System.out.println( findSubstring("wordgoodgoodgoodbestword", words));
    }

    public static List<Integer>findSubstring(String s, String[] words) {
        Set<Integer> list = new HashSet<>();
        List<String> subString = generateConcatenatedStrings(words);

        for ( String str : subString) {

            int result = s.indexOf(str);
            if(result != -1)
                list.add(result);
        }
        return new ArrayList<>(list);
    }

    public static List<String> generateConcatenatedStrings(String[] words) {
        List<String> result = new ArrayList<>();
        generatePermutations(words, 0, result);
        return result;
    }

    private static void generatePermutations(String[] words, int start, List<String> result) {
        if (start == words.length - 1) {
            result.add(String.join("", words));
        } else {
            for (int i = start; i < words.length; i++) {
                swap(words, start, i);
                generatePermutations(words, start + 1, result);
                swap(words, start, i); // backtrack
            }
        }
    }

    private static void swap(String[] words, int i, int j) {
        String temp = words[i];
        words[i] = words[j];
        words[j] = temp;
    }
}
