import java.util.Scanner;

class Assistent {
   private Scanner sc=new Scanner(System.in);
    int getNumber(String welcome, int min, int max) {
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
        double getNumber(String welcome, double min, double max) {
            System.out.println(welcome);
            if (sc.hasNextDouble()) {
                double a = sc.nextDouble();
                if (a >= min && a <= max) return a;
                else return getNumber(welcome, min, max);
            } else {
                sc.next();
                return getNumber(welcome, min, max);
            }
        }
}
