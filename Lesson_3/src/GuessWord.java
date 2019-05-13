import java.util.*;

public class GuessWord {
    Scanner sc = new Scanner(System.in);
    String[] words = {"apple", "orange", "lemon", "banana", "apricot",
            "avocado", "broccoli", "carrot", "cherry", "garlic", "grape",
            "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive",
            "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

    public void playGame() {
        System.out.println(Arrays.deepToString(words));
        int numTargetWord = (int) (Math.random() * words.length);
        String playerGuess;
        do {
            playerGuess = getWord("enter the word");
            System.out.print(compare(words[numTargetWord], playerGuess));
            if (!words[numTargetWord].equals(playerGuess)) System.out.println("********************");
        } while (!words[numTargetWord].equals(playerGuess));
        System.out.println(" You won!");
    }

    public String getWord(String welcome) {
        System.out.println(welcome);
        String str = sc.next();
        return str;
    }

    public String compare(String str1, String str2) {
        int minLength = Math.min(str1.length(), str2.length());
        char[] guess = new char[minLength];
        for (int i = 0; i < minLength; i++) {
            if (str1.charAt(i) == str2.charAt(i)) guess[i] = str1.charAt(i);
            else guess[i] = '*';
        }
        String guessString = str1.copyValueOf(guess);
        return guessString;
    }
}
