package _2021.february;

public class CheckingWhetherAStringContainsOnlyDigits {


    public static boolean containsOnlyDigitsA(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) return false;
        }
        return true;
    }

    public static boolean containsOnlyDigitsB(String str) {
        return str.chars()
                .allMatch(Character::isDigit);
    }


    public static boolean containsOnlyDigitsC(String str) {
        return str.matches("[0-9]+");
    }

    public static void main(String[] args) {
        System.out.println(containsOnlyDigitsA("1111"));
        System.out.println(containsOnlyDigitsB("1111"));
        System.out.println(containsOnlyDigitsC("1111"));
        System.out.println(containsOnlyDigitsA("aaaa"));
        System.out.println(containsOnlyDigitsB("aaaa"));
        System.out.println(containsOnlyDigitsC("aaaa"));
    }


}
