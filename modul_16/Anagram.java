import java.util.Arrays;
import java.util.Scanner;

public class Anagram {
    public static boolean thisAnagram(String str1, String str2){

        //remove spaces
        str1 = str1.replaceAll("\\s", "").toLowerCase();
        str2 = str2.replaceAll("\\s", "").toLowerCase();

        if(str1.length() != str2.length()){
            return false;
        }

        //convert to char
        char[] charStr1 = str1.toCharArray();
        char[] charStr2 = str2.toCharArray();
        //array sort
        Arrays.sort(charStr1);
        Arrays.sort(charStr2);

        return Arrays.equals(charStr1, charStr2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Masukkan kata pertama: ");
        String word1 = scanner.nextLine();
        System.out.println("Masukkan kata kedua: ");
        String word2 = scanner.nextLine();

        System.out.println(thisAnagram(word1, word2));





//        if (thisAnagram(word1, word2)){
//            System.out.println(word1 + " and " + word2 + " are anagram");
//        } else {
//            System.out.println(word1 + " and " + word2 + " not anagram");
//        }
    }
}
