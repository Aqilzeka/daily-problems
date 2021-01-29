package _2021.january;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ReversingLettersAndWords {

    private static final String WHITESPACE = " ";
    private static final Pattern PATTERN = Pattern.compile(" +");

    public static String reverseWordsA(String str) {
        String[] words = str.split(WHITESPACE);
        StringBuilder reversedString = new StringBuilder();

        for (String word : words) {

            for (int i = word.length() - 1; i >= 0; i--) {
                reversedString.append(word.charAt(i));
            }

            reversedString.append(WHITESPACE);
        }

        return reversedString.toString();
    }


    public static String reverseWordsB(String str) {
        return PATTERN.splitAsStream(str)
                .map(word -> new StringBuilder(word).reverse())
                .collect(Collectors.joining(" "));
    }

    public static String reverse(String str) {

        return new StringBuilder(str).reverse().toString();
    }


    public static void main(String[] args) {
        System.out.println(reverseWordsA("My Name is Aqil"));
        System.out.println(reverseWordsB("My Name is Aqil"));
        System.out.println(reverse("My Name is Aqil"));
    }

}
