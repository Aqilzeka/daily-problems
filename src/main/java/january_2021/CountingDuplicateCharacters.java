package january_2021;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CountingDuplicateCharacters {

    public static void main(String[] args) {

        System.out.println("---------------- CASE 1 -----------------\n");

        countDuplicateCharactersA("Hi, this is Aqil")
                .forEach((k,v)->
                        System.out.printf("Character: %s, Count: %s%n", k,  v));

        System.out.println("\n\n---------------- CASE 2 -----------------\n");

        countDuplicateCharactersB("Hi, this is Aqil")
                .forEach((k,v)->
                        System.out.printf("Character: %s, Count: %s%n", k,  v));

    }

    public static Map<Character, Integer> countDuplicateCharactersA(String str) {
        Map<Character, Integer> result = new HashMap<>();

        /**
         * or use
         * for (int i = 0; i<str.length(); i++) {
         *      char ch = str.charAt(i);
         *      result.compute(ch, (k, v) -> (v == null) ? 1 : ++v);
         * }
         */

        for (char ch : str.toCharArray()) {
            result.compute(ch, (k, v) -> (v == null) ? 1 : ++v);
        }

        return result;
    }

    public static Map<Character, Long> countDuplicateCharactersB(String str) {

        return str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
    }


}