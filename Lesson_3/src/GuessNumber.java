import java.util.Scanner;

public class GuessNumber {
    Scanner sc = new Scanner(System.in);

    public void playGame() {
        int answer;
        do {
            System.out.println(game());
            answer = getNumber("Repeat? 1-Yes/0-No", 0, 1);
        } while (answer == 1);
    }

    public String game() {
        int goal = (int) (Math.random() * 10);
        for (int i = 0; i < 3; i++) {
            int guess = getNumber("Guess the number from 0 to 9", 0, 9);
            if (guess == goal) {
                return ("You won!");
            } else if (guess < goal) System.out.println("less");
            else System.out.println("more");
        }
        return ("You have lost");
    }

    public int getNumber(String welcome, int min, int max) {
        System.out.println(welcome);
        if (sc.hasNextInt()) {
            int a = sc.nextInt();
            if (a >= min && a <= max) return a;
            else return getNumber(welcome, min, max);
        } else {
            sc.next();
            return getNumber(welcome, min, max);
        }

    }

    public int getNumber2(String welcome, int min, int max) {//без рекурсии
        int a = min - 1;
        do {
            System.out.println(welcome);
            if (sc.hasNextInt()) {
                a = sc.nextInt();
            } else sc.next();
        } while (a < min || a > max);
        return a;
    }
}