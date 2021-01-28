package _2021.january;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatedCharacter {
    private static final int EXTENDED_ASCII_CODES = 256;

    public static char firstNonRepeatedCharacterA(String str) {
        int[] flags = new int[EXTENDED_ASCII_CODES];

        Arrays.fill(flags, -1);

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (flags[ch] == -1) flags[ch] = i;
            else flags[ch] = -2;
        }

        int position = Integer.MAX_VALUE;

        for (int i = 0; i < EXTENDED_ASCII_CODES; i++) {
            if (flags[i] >= 0) {
                position = Math.min(position, flags[i]);
            }
        }

        return position == Integer.MAX_VALUE ? Character.MIN_VALUE : str.charAt(position);
    }

    public static char firstNonRepeatedCharacterB(String str) {
        Map<Character, Integer> chars = new LinkedHashMap<>();

        for (char ch : str.toCharArray()) {
            chars.compute(ch, (k, v) -> (v == null) ? 1 : ++v);
        }

        for (Map.Entry<Character, Integer> entry : chars.entrySet()) {
            if (entry.getValue() == 1) return entry.getKey();
        }

        return Character.MIN_VALUE;
    }

    public static String firstNonRepeatedCharacterC(String str) {


        return String.valueOf(Character.toChars(str.codePoints()
                        .boxed()
                        .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                        .entrySet()
                        .stream()
                        .filter(e -> e.getValue() == 1L)
                        .findFirst()
                        .map(Map.Entry::getKey)
                        .orElse((int) Character.MIN_VALUE)));

    }


    public static void main(String[] args) {
        System.out.println(firstNonRepeatedCharacterA("AbAAu"));
        System.out.println(firstNonRepeatedCharacterB("AbAAu"));
        System.out.println(firstNonRepeatedCharacterC("AbAAu"));
    }
}
